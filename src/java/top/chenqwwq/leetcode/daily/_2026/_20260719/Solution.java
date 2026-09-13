package top.chenqwwq.leetcode.daily._2026._20260719;

public class Solution {
    public String smallestSubsequence(String s) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        boolean[] vis = new boolean[26];
        // cbacdcbcd
        for (char c : s.toCharArray()) {
            if (vis[c - 'a']) {
                hash[c - 'a']--;
                continue;
            }
            while (!ans.isEmpty() && c < ans.charAt(ans.length() - 1) && hash[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                vis[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }
            vis[c - 'a'] = true;
            hash[c - 'a']--;
            ans.append(c);
        }
        return ans.toString();
    }
}