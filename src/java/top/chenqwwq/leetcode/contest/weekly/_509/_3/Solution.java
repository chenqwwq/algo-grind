package top.chenqwwq.leetcode.contest.weekly._509._3;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution().divisibleGame(new int[] { 1, 1, 1, 1, 1 });
    }

    static final int MOD = (int) 1e9 + 7;

    public int divisibleGame(int[] nums) {
        final int n = nums.length;
        Set<Integer> ss = new HashSet<>(), vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (vis.contains(nums[i]))
                continue;
            vis.add(nums[i]);
            ss.addAll(primeFactors(nums[i]));
        }
        if (ss.isEmpty()) {
            long min = 0;
            for (int num : nums)
                min = Math.min(min,num);
            return (int) (((-min * 2) % MOD + MOD) % MOD);
        }

        long md = -0x3f3f3f3f, mk = 0;
        for (int k : ss) {
            // 如果当前元素可以被整除
            long[] dp = new long[n];
            dp[0] = (nums[0] % k == 0 ? nums[0] : 0);
            long max = dp[0];
            for (int i = 1; i < n; i++) {
                if (nums[i] % k == 0) {
                    dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                } else {
                    dp[i] = Math.max(dp[i - 1] - nums[i], -nums[i]);
                }
                max = Math.max(max, dp[i]);
            }
            if (max > md || (max == md && k < mk)) {
                md = max;
                mk = k;
            }
        }
        return (int) ((md * mk % MOD + MOD) % MOD);
    }

    public Set<Integer> primeFactors(int n) {
        Set<Integer> res = new HashSet<>();
        for (int i = 2; (long) i * i <= n; i++) { // long 防溢出
            while (n % i == 0) {
                res.add(i);
                n /= i;
            }
        }
        if (n > 1)
            res.add(n); // 剩下的 > 1 一定是质数
        return res;
    }
}