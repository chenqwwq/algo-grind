package top.chenqwwq.leetcode.daily._2026._20260830;

public class Solution {
    public int minimumDeletions(int[] nums) {
        final int n = nums.length;
        if (n <= 2)
            return n;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxi = -1, mini = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                mini = i;
            }
        }
        int l = Math.min(maxi, mini), r = Math.max(maxi, mini);
        return Math.min(n - (r - l - 1), Math.min(r + 1, n - l));
    }
}