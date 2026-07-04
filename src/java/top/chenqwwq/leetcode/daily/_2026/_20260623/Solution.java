package top.chenqwwq.leetcode.daily._2026._20260623;

public class Solution {
    int mod = (int) (1e9 + 7); // 取余

    public int zigZagArrays(int n, int l, int r) {
        // 长度为 n 的数组，取值范围在「l，r」
        // dp[i][flag][j]
        // i 的范围是 0 -> 1,j 的范围是 l -> r
        final int m = r - l + 1;
        int[][][] dp = new int[n][2][m + 1];
        // dp[i][0][j] 表示第 i 位,第二位 0 表示升序，1 表示降序,第三位表示最后一个元素的值
        // 状态转移方程：
        // dp[i][0][j] = sum(k < j) dp[i][1][k]
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < m; j++) {
                dp[0][i][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {

        }

        return 1;
    }
}