package top.chenqwwq.leetcode.daily._2026._20260705;

import java.util.Arrays;
import java.util.List;

public class Solution {
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        new Solution().pathsWithMaxScore(List.of("E23","2X2","12S"));
    }

    public int[] pathsWithMaxScore(List<String> board) {
        // 正反都一样
        final int n = board.size(), m = board.get(0).length();
        // 第一行第一列都加一圈，避免处理边界情况
        int[][] ms = new int[n + 1][m + 1]; // 节点 i、j 的路径最大和
        int[][] ws = new int[n + 1][m + 1]; // 节点 i、j 的路径数量
        for (int[] ts : ms) {
            Arrays.fill(ts, -0x3f3f3f3f);
        }
        ms[0][0] = 0;
        ws[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board.get(i).charAt(j);
                if (c == 'X')
                    continue; // 跳过 阻塞节点

                // 三个方向的最大值
                ms[i + 1][j + 1] = Math.max(ms[i][j], Math.max(ms[i + 1][j], ms[i][j + 1]));
                int t = ms[i + 1][j + 1];
                long w = 0L;

                if (t == ms[i][j])
                    w += ws[i][j];
                if (t == ms[i + 1][j])
                    w += ws[i + 1][j];
                if (t == ms[i][j + 1])
                    w += ws[i][j + 1];

                ws[i + 1][j + 1] = (int) (w % mod);
                if ('1' <= c && c <= '9')
                    ms[i + 1][j + 1] = t + c - '0';
            }
        }
        return ms[n][m] < 0 ? new int[] { 0, 0 } : new int[] { ms[n][m], ws[n][m] };
    }
}