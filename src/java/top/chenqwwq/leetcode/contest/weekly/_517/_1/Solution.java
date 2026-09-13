package top.chenqwwq.leetcode.contest.weekly._517._1;

import java.util.Arrays;

public class Solution {
    public int countSpecialIntegers(int[] nums) {
        int[] hash = new int[101];
        Arrays.fill(hash, -1);
        for (int i = 0; i < nums.length; i++) {
            if (hash[nums[i]] == i - 1 || hash[nums[i]] == -1)
                hash[nums[i]] = i;
            else
                hash[nums[i]] = -2;
        }

        int ans = 0;
        for (int n : hash) {
            if (n >= 0)
                ans++;
        }
        return ans;
    }
}