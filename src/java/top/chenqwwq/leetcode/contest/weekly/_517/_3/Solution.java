package top.chenqwwq.leetcode.contest.weekly._517._3;

import java.util.*;

/**
 * 最少操作次数使子集和等于目标值
 * <p>
 * 每次操作选择一个元素 x，变为 2*x 或 x/2。
 * 对每个元素，操作序列为：先除若干次，再乘若干次，即 (x >> k) << j，代价 = k + j。
 * 求最少操作次数使得操作后存在一个子集和为 sum，无法做到返回 -1。
 *
 * @author chenqwwq
 * @date 2026/8/30
 */
public class Solution {

    private static final int INF = Integer.MAX_VALUE / 2;

    public int minOperations(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x : nums) {
            if (x == 0) {
                continue; // 0 不影响和，跳过
            }

            // 计算当前元素到达每个值的最小代价
            // 可达值 = (x >> k) << j，代价 = k + j（先除 k 次，再乘 j 次）
            int[] minCost = new int[sum + 1];
            Arrays.fill(minCost, INF);

            for (int k = 0, base = x; base > 0; k++, base >>= 1) {
                for (int j = 0, val = base; val <= sum; j++, val <<= 1) {
                    int cost = k + j;
                    if (cost < minCost[val]) {
                        minCost[val] = cost;
                    }
                }
            }

            // 0-1 背包：读旧 dp，写新 ndp，保证每个元素只选一次
            int[] ndp = dp.clone();
            for (int val = 0; val <= sum; val++) {
                int c = minCost[val];
                if (c == INF) {
                    continue;
                }
                for (int s = val; s <= sum; s++) {
                    if (dp[s - val] != INF) {
                        ndp[s] = Math.min(ndp[s], dp[s - val] + c);
                    }
                }
            }
            dp = ndp;
        }

        return dp[sum] == INF ? -1 : dp[sum];
    }
}