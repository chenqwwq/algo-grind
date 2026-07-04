package top.chenqwwq.leetcode.contest.biweek._186._2;

public class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        final int n = nums.length;
        int[] ps = new int[n]; // 记录后缀最大值
        ps[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ps[i] = Math.max(nums[i], ps[i + 1]);
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,nums[i] + (i + k < n ? ps[i+k] : -0x3f3f3f3f));
        }
        return ans;
    }
}