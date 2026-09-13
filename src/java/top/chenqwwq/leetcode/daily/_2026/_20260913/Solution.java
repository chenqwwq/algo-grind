package top.chenqwwq.leetcode.daily._2026._20260913;

public class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        final int n = img1.length;
        int ans = 0;
        for (int i = -n + 1; i < n; i++) {
            for (int j = -n + 1; j < n; j++) {
                ans = Math.max(ans, h(img1, img2, i, j));
            }
        }
        return ans;
    }

    private int h(int[][] img1, int[][] img2, int x, int y) {
        final int n = img1.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int xx = i + x, yy = j + y;
                if (xx >= n || yy >= n || xx < 0 || yy < 0)
                    continue;
                if (img1[i][j] == 0 || img2[xx][yy] == 0)
                    continue;
                ret += 1;
            }
        }
        return ret;
    }
}