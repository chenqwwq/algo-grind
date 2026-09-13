package top.chenqwwq.leetcode.daily._2026._20260715;

public class Solution {
    public int gcdOfOddEvenSums(int n) {
        int a = 0, b = 0;
        for (int i = 1, j = 2, c = 0; c < n; c++) {
            a += i;
            b += j;
            i += 2;
            j += 2;
            c++;
        }
        return gcd(a, b);
    }

    private int gcd(int i, int j) {
        int m = Math.min(i, j);
        while (m >= 1) {
            if (i % m == 0 && j % m == 0)
                return m;
        }
        return -1;
    }
}