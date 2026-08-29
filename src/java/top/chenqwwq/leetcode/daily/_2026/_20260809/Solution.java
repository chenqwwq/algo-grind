package top.chenqwwq.leetcode.daily._2026._20260809;

public class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // 前缀和处理
        int[] ps = new int[n];
        ps[0] = piles[0];
        for (int i = 1; i < n; i++) {
            ps[i] = piles[i] + ps[i - 1];
        }

        return dfs(0, n, 1, ps, new int[n][n + 1]);
    }

    private int dfs(int i, int n, int m, int[] ps, int[][] memo) {
        if (i >= n)
            return 0;
        // 剩下的全拿了（剩余堆数是 n - i）
        if (2 * m >= n - i) {
            return ps[n - 1] - (i > 0 ? ps[i - 1] : 0);
        }
        if (memo[i][m] != 0)
            return memo[i][m];

        int max = -1;
        for (int k = 1; k <= 2 * m; k++) {
            // 选中 i - i + k
            int left = ps[n - 1] - ps[i + k - 1];   // 后面的价值
            int pm = dfs(i + k, n, Math.max(k, m), ps, memo);
            int cur = ps[i + k - 1] - (i > 0 ? ps[i - 1] : 0);
            max = Math.max(max, left - pm + cur);
        }
        memo[i][m] = max;
        return max;
    }

    public static void main(String[] args) {
        int stoneGameII = new Solution().stoneGameII(new int[] { 1, 2, 3, 4, 5, 100 });
        System.out.println(stoneGameII);
    }
}