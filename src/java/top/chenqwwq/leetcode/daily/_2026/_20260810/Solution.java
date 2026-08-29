package top.chenqwwq.leetcode.daily._2026._20260810;


public class Solution {
    public boolean winnerSquareGame(int n) {
        // 不是比数量，最后无法操作的人算输
        if (n == 0)
            return false;
        int[] memo = new int[n + 1];
        memo[0] = -1;
        return dfs(memo, n) == 1; // 1 表示必胜，-1 表示必输
    }

    public int dfs(int[] memo, int i) {
        if (i == 0)
            return -1;
        if (memo[i] != 0)
            return memo[i];

        for (int x = 1; x * x <= i; x++) {
            if (dfs(memo, i - x * x) == -1) {
                return memo[i] = 1;
            }
        }

        return memo[i] = -1;

    }
}