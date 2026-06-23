package template.segment_tree;



/**
 * 非动态开点的线段树实现,带懒标记
 * <p>
 * 求区间的最大值
 * <p>
 * !!!!! 基1
 * <p>
 * 计划包含一下以下方法
 * 1. 初始化
 * 2. 区间更新 / 单点更新
 * 3  区间查询 / 单点查询
 *
 * @author chenqwwq
 * @date 2022/5/26
 **/
public class SegmentTree_Basic_Max {

    private final static int N = (int) 1e9 + 10;
    private final static int M = (int) 1e5;

    public final int[] tree = new int[M];
    private final int[] lazy = new int[M];


    // 区间查询
    // 单点查询不用说了,直接搬过去吧

    public int query(int l, int r) {
        return query(1, 1, N - 1, l, r);
    }

    private int query(int pos, int l, int r, int ll, int rr) {
        if (l >= ll && r <= rr) return tree[pos];
        pushDown(pos);
        int mid = l + r >> 1;
        int ans = -1;
        if (ll <= mid) ans = Math.max(ans, query(pos << 1, l, mid, ll, rr));
        if (rr > mid) ans = Math.max(ans, query(pos << 1 | 1, mid + 1, r, ll, rr));
        return ans;
    }


    // 区间更新
    // 区间更新如果都透穿到最底下复杂度会爆炸的,所以借助懒标记
    // 单点更新就是 ll rr 一样

    public void update(int ll, int rr, int val) {
        update(1, 1, N, ll, rr, val);
    }

    private void update(int u, int l, int r, int ll, int rr, int v) {
        if (ll <= l && r <= rr) {
            tree[u] += v;
            lazy[u] += v;
            return;
        }
        pushDown(u);
        final int mid = (l + r) >> 1;
        if (ll <= mid) update(u << 1, l, mid, ll, rr, v);
        if (mid < r) update(u << 1 | 1, mid + 1, r, ll, rr, v);
        pushUp(u);
    }

    private void pushUp(int u) {
        tree[u] = Math.max(tree[u << 1], tree[u << 1 | 1]);
    }

    private void pushDown(int u) {
        if (lazy[u] <= 0) return;
        lazy[u << 1] += lazy[u];
        lazy[u << 1 | 1] += lazy[u];
        tree[u << 1] += lazy[u];
        tree[u << 1 | 1] += lazy[u];
        lazy[u] = 0;
    }
}
