package top.chenqwwq.leetcode.contest.weekly._510._2;

public class Solution {

    int mod = (int) (1e9 + 7);

    public int minimumCost(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long n = sum / k + (sum % k == 0 ? 0 : 1) - 1;
        long ans;
        if (n % 2 == 0) {
            ans = (n / 2L % mod) * ((n + 1L) % mod) % mod;
        } else {
            ans = (n % mod) * ((n + 1L) / 2 % mod) % mod;
        }
        return (int)ans;
    }
}