package top.chenqwwq.leetcode.contest.weekly._512._1;

public class Solution {
    public int largestInteger(int n, int s) {
        if (s > n * 9)
            return -1;
        int num = 0;
        while (s > 0 || n-- > 0) {
            int k = Math.min(s, 9);
            s -= k;
            num = num * 10 + k;
        }
        return num;
    }
}