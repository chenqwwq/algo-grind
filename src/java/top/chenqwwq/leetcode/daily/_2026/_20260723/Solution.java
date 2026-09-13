package top.chenqwwq.leetcode.daily._2026._20260723;

public class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;    // nums 是 1-n 的重排序

        // 因为 n ^ m = m ^ n，所以就相当于 1-n 的所有异或
        // (32 - Integer.numberOfLeadingZeros(n)) 获取最大数位
        return n <= 2 ? n : 1 << (32 - Integer.numberOfLeadingZeros(n));   
    }
}
