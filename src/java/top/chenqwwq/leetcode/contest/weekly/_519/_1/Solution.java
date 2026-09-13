package top.chenqwwq.leetcode.contest.weekly._519._1;

public class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        final int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            rowShift[i] %= n;
            colShift[i] %= n;
        }

        // 先处理行内的转换
        for (int i = 0; i < n; i++) {   // 行
            for (int j = 0; j < n; j++) { // 列
                // rowShift 表示第 i 行是否需要移动
                int y = (j - rowShift[i] + n) % n;
                ans[i][y] = grid[i][j];
            }
        }

        // 再进行列内的移动
        for (int i = 0; i < n; i++) { // 列
            for (int j = 0; j < n; j++) { // 行
                int x = (j - colShift[i] + n) % n;
                grid[x][i] = ans[j][i];
            }
        }

        return grid;
    }
}