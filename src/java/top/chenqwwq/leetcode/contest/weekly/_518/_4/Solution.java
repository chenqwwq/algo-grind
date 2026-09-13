package top.chenqwwq.leetcode.contest.weekly._518._4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    int[][] dif = new int[4][2];
    {
        dif[0] = new int[] { 0, 1 };
        dif[1] = new int[] { 1, 0 };
        dif[2] = new int[] { 0, -1 };
        dif[3] = new int[] { -1, 0 };
    }

    // 定义状态
    // new int[]{距离，x，y，方向编码，可转向次数}

    public int minCost(int[][] grid, int k) {
        final int n = grid.length, m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> Integer.compare(o1[0], o2[0]));
        int[][][] vis = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(vis[i][j], 0x3f3f3f3f);
            }
        }
        pq.add(new int[] { grid[0][0], 0, 0, 1, k }); // 初始位置向下
        vis[0][0][1] = grid[0][0];
        pq.add(new int[] { grid[0][0], 0, 0, 0, k }); // 初始位置向右
        vis[0][0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            int[] stat = pq.poll();

            for (int i = 0; i < 4; i++) {
                if (stat[3] != i && stat[4] < 1)
                    continue; // 无法转向
                int x = stat[1], y = stat[2];
                int xx = x + dif[i][0], yy = y + dif[i][1];
                if (xx < 0 || yy < 0 || xx >= n || yy >= m)
                    continue; // 下标非法
                int cost = stat[0] + grid[xx][yy];
                if (xx == n - 1 && yy == m - 1)
                    return cost;
                if (vis[xx][yy][i] <= cost)
                    continue;
                vis[xx][yy][i] = cost;
                pq.add(new int[] { cost, xx, yy, i, stat[4] - (stat[3] == i ? 0 : 1) });
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int t = new Solution().minCost(new int[][] { { 17, 3 }, { 18, 17 } }, 1);
        System.out.println(t);
    }
}