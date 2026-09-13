package top.chenqwwq.leetcode.daily._2026._20260905;

public class Solution {
    public int firstStableIndex(int[] nums, int k) {
        final int n = nums.length;
        int[] ms = new int[n];
        ms[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ms[i] = Math.min(ms[i + 1], nums[i]);
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (max - ms[i] <= k)
                return i;
        }
        return -1;
    }
}