package top.chenqwwq.leetcode.daily._2026._20260704;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private int ans = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int[] e : roads) {
            int x = e[0], y = e[1], dis = e[2];
            g[x].add(new int[]{y, dis});
            g[y].add(new int[]{x, dis});
        }

        boolean[] vis = new boolean[n + 1];
        // 遍历节点 1 所在连通块
        dfs(1, g, vis);
        return ans;
    }

    private void dfs(int x, List<int[]>[] g, boolean[] vis) {
        vis[x] = true; // 避免重复访问
        for (int[] e : g[x]) {
            ans = Math.min(ans, e[1]);
            if (!vis[e[0]]) {
                dfs(e[0], g, vis);
            }
        }
    }
}
