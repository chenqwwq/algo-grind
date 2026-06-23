package template.segment_tree;


/**
 * 动态开点线段树，在没有值域,或者范围很大并且无法映射到小片范围的时候可以采用该类
 * （对于 0 ～ 1e9 的数据范围 4*n 的范围明显不可接受
 * 如果是离线查询可以使用离散化处理所有数据尽量将数据范围收缩，在线大范围必须使用动态开点
 *
 * @author chenqwwq
 * @date 2022/6/6
 **/
public class DynamicSegmentTree {
    private static final class Node {
        int ll, rr;
        Node lc, rc; // 左右子节点
        int add = 0, data = 0; // 懒标记和真实数据

        public Node(int ll, int rr) {
            this.ll = ll;
            this.rr = rr;
        }
    }

    public static final int N = (int) 1e9 + 7;
    private final Node root;

    public DynamicSegmentTree() {
        this.root = new Node(0, N);
    }

    public DynamicSegmentTree(int ll, int rr) {
        this.root = new Node(ll, rr);
    }


    // 区间更新
    // 单点更新就是 l,r 相同

    public void update(int l, int r, int v) {
        update(root, l, r, v);
    }


    /**
     * ll,rr 表示 node 的值域
     * l,r 表示更新的区间
     * v 表示更新的值
     */
    private void update(Node node, int l, int r, int v) {
        // l <= ll <= rr < r
        if (l <= node.ll && node.rr <= r) {
            node.data += v;
            node.add += v;
            return;
        }

        // 懒创建
        // 中间值
        int mid = node.ll + ((node.rr - node.ll) >> 1);
        lazyCreate(node, mid);

        // 下推
        pushDown(node);


        // 分段更新
        if (l <= mid) update(node.lc, l, r, v);
        if (r > mid) update(node.rc, l, r, v);

        // 更新当前值
        pushUp(node);
    }

    // 区间查询

    public int query(int l, int r) {
        return query(root, l, r);
    }

    private int query(Node node, int l, int r) {
        if (l <= node.ll && r >= node.rr) return node.data;
        int mid = node.ll + ((node.rr - node.ll) >> 1);
        lazyCreate(node, mid);
        pushDown(node);
        int ans = 0;
        if (l <= mid) ans = query(node.lc, l, r);
        if (mid < r) ans = Math.max(query(node.rc, l, r), ans);
        return ans;
    }


    private void pushDown(Node node) {
        if (node.add == 0) return;
        node.lc.data += node.add;
        node.lc.add += node.add;
        node.rc.data += node.add;
        node.rc.add += node.add;
        node.add = 0;
    }

    private void lazyCreate(Node node, int mid) {
        if (node.lc == null) node.lc = new Node(node.ll, mid);
        if (node.rc == null) node.rc = new Node(mid + 1, node.rr);
    }

    private void pushUp(Node node) {
        node.data = Math.max(node.lc.data, node.rc.data);
    }
}