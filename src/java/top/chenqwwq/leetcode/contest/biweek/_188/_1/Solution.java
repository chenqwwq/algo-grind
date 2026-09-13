package top.chenqwwq.leetcode.contest.biweek._188._1;

public class Solution {
    public int countValidPrefixes(String s) {
        int[] hash = new int[2];
        int ans = 0;
        for (char c : s.toCharArray()) {
            hash[c - '0']++;
            if (Math.abs(hash[1] - hash[0]) < 2)
                ans++;
        }
        return ans;
    }
}