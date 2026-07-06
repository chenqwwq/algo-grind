package top.chenqwwq.leetcode.contest.weekly._487._1;

/**
 * @author chenqwwq
 * @date 2026/2/7
 **/
public class Solution {
    public int countMonobit(int n) {
        if (n == 0) return 1;
        int cnt = 1;
        for (int cur = 1; cur <= n; cur = (cur << 1) + 1) cnt++;
        return cnt;
    }
}