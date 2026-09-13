package top.chenqwwq.leetcode.contest.biweek._190._1;

public class Solution {
    public int minBishopMoves(int[] s, int[] t) {
        if (((s[0] + s[1]) & 1) != ((t[0] + t[1]) & 1))
            return -1;

        return ((s[0] + s[1]) == (t[0] + t[1]) || (s[0] - s[1] == t[0] - t[1])) ? 1 : 2;
    }
}