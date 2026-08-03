package top.chenqwwq.leetcode.daily._2026._20260726;

import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        final int n = nums.length;
        if (n < 3)
            return -1;
        Arrays.sort(nums);
        if (nums[n - 1] < 0)
            return nums[n - 1] * nums[n - 2] * nums[n - 3];

        int m = nums[n - 1] * nums[n - 2] * nums[n - 3];

        if (nums[0] < 0 && nums[1] < 0) {
            return Math.max(m, nums[0] * nums[1] * nums[n - 1]);
        }

        return m;
    }
}