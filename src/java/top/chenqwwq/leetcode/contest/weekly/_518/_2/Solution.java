package top.chenqwwq.leetcode.contest.weekly._518._2;

public class Solution {
    public int countGoodRotations(int[] nums) {
        final int n = nums.length;
        long total = 0, half = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
            if (i < n / 2)
                half += nums[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (half > total - half)
                ans++;
            half -= nums[i];
            half += nums[(i + (n / 2)) % n];
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().countGoodRotations(new int[]{1,2,3,4,5,6});
    }
}