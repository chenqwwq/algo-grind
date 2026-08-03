package top.chenqwwq.leetcode.daily._2026._20260727;

public class Solution {
    public int maxProduct(int[] nums) {
        int i = -1, j = -1;
        for (int num : nums) {
            if (num > i) {
                j = i;
                i = num;
            } else if (num > j) {
                j = num;
            }
        }
        return (i - 1) * (j - 1);
    }
}