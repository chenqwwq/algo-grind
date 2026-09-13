package top.chenqwwq.leetcode.daily._2026._20260706;

import java.util.Arrays;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        final int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            int t = Integer.compare(a[1], b[1]);
            if (t == 0)
                return Integer.compare(b[0], a[0]);
            return t;
        });

        // 按照右边界排序
        // [[4,10],[3,10],[5,11]]
        // [[12,30],[26,40],[25,40]]



        int cnt = 1;
        int p = intervals[n-1][0];
        for (int i = n-2; i >= 0; i--) {
            if(p <= intervals[i][1] && p <= intervals[i][0]) continue;
            cnt++;
            p = intervals[i][0];
        }
        return cnt;
    }
}