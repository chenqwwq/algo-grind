package top.chenqwwq.leetcode.daily._2026._20260725;

public class Solution {
    public int maxProduct(int n) {
        if(n < 10) return -1;
        int a = -1, b = -1;
        while (n != 0) {
            int t = n % 10;
            if (t > a) {
                b = a;
                a = t;
            } else if (t > b) {
                b = t;
            }
            n /= 10;
        }
        return a * b;
    }
}