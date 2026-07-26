package top.chenqwwq.leetcode.contest.weekly._511._1;

public class Solution {
    public boolean canReach(int[] start, int[] target) {
        return ((Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1])) & 1) == 0;
    }
}