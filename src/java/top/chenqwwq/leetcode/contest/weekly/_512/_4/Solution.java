package top.chenqwwq.leetcode.contest.weekly._512._4;

import java.lang.reflect.InaccessibleObjectException;
import java.util.PriorityQueue;
import java.util.logging.FileHandler;

public class Solution {
    public long minCost(int m, int n, int[][] penalty) {
        // m 表示行数，n 表示列数, penalty 表示违规成本
        // 刚开始在下标 (1,1),下次开始算是 1

        // 基础花费是（i + 1） * (j + 1)
        // 合规的行动含义：奇数合规的行动方法是 右、下, 偶数合规的行动方法是 左、上

        // 状态定义:dp[i][j][t] 表示在下标 i,j，t 表示基础状态，0 表示为奇数状态，1 表示偶数状态
        // long[][][] dp = new long[m][n][2];
        // dp[0][0][0] = 1;
        // dp[0][0][1] = 1 + penalty[0][0];
        // 好像没办法使用简单 dp，因为方向按照当前移动步数其实上下左右都可以，并不是不可逆向的状态

        // 使用 dijkstra
        final PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[] { 1, 0, 0, 0 });
        pq.add(new long[] { 1 + penalty[0][0], 0, 0, 1 });

        long[][][] stat = new long[m][n][2];

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            // 当前下标
            int i = top[1], j = top[2];
            int cost = top[0];
        }
    }
}