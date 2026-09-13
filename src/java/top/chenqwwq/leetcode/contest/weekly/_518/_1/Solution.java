package top.chenqwwq.leetcode.contest.weekly._518._1;

public class Solution {
    public int countRotations(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if (k == h(sb.toString())) {
                ans++;
            }
        }
        return ans;
    }

    public int h(String s) {
        final int n = s.length();
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                c++;
            }
        }
        return c;
    }
}