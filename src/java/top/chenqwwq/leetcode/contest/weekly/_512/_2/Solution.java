package top.chenqwwq.leetcode.contest.weekly._512._2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        final int n = series1.length, m = series2.length;
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0, j = 0;
        while (i < n || j < m) {
            int t1 = i < n ? series1[i][0] : Integer.MAX_VALUE;
            int v1 = i < n ? series1[i][1] : 0;
            int t2 = j < m ? series2[j][0] : Integer.MAX_VALUE;
            int v2 = j < m ? series2[j][1] : 0;
            List<Integer> l = new ArrayList<>();
            l.add(Math.min(t1, t2));
            l.add(v1 + v2);
            if (t1 < t2)
                t1++;
            else if (t1 > t2)
                t2++;
            else {
                t1++;
                t2++;
            }
            ans.add(l);
        }
        return ans;
    }
}