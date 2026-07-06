package top.chenqwwq.leetcode.contest.weekly._509._1;

public class Solution {
    public int maxDigitRange(int[] nums) {
        int max = -1, sum = 0;
        for (int num : nums) {
            int t = h(num);
            if (t > max) {
                max = t;
                sum = num;
            } else if (t == max) {
                sum += num;
            }
        }
        return sum;
    }

    private int h(int num) {
        int min = 10, max = -1;
        while (num != 0) {
            min = Math.min(min, num % 10);
            max = Math.max(max, num % 10);
            num /= 10;
        }
        return max - min;
    }
}