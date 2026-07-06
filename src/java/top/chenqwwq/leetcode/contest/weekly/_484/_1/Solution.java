package top.chenqwwq.leetcode.contest.weekly._484._1;

/**
 * @author chenqwwq
 * @date 2026/1/11
 **/
public class Solution {
    public int residuePrefixes(String s) {
        final int n = s.length();
        int[] hash = new int[26];
        int cnt = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (++hash[s.charAt(i) - 'a'] == 1) {
                cnt++;
            }
            if (cnt == (i + 1) % 3) {
                ans++;
            }
        }
        return ans;
    }
}