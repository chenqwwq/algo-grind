package top.chenqwwq.leetcode.contest.biweek._189._2;

public class Solution {
    public int minOperations(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, get(sb.toString()) + i);
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return ans;
    }

    public int get(String s) {
        int l = 0, r = s.length() - 1;
        int ans = 0;
        while (l < r) {
            char a = s.charAt(l), b = s.charAt(r);
            ans += Math.min((a - b + 26) % 26, (b - a + 26) % 26);
            l++;
            r--;
        }
        return ans;
    }
}