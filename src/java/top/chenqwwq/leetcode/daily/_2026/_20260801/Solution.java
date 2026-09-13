package top.chenqwwq.leetcode.daily._2026._20260801;

public class Solution {
    public boolean predictTheWinner(int[] nums) {
        final int n = nums.length;
        int[][] dp = new int[n][n];
        // dp[i][j] 表示在子数组 i,j 下，先手最高能拿几分
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // dp[j][i]
                dp[j][i] = Math.max(nums[j] - dp[j + 1][i], nums[i] - dp[j][i - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }
}