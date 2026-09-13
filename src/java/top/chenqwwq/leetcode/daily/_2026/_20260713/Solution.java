package top.chenqwwq.leetcode.daily._2026._20260713;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    List<Integer> ans;

    public List<Integer> sequentialDigits(int low, int high) {
        ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            h(low, high, i, i + 1);
        }
        ans.sort(Comparator.comparingInt(a -> a));
        return ans;
    }

    private void h(int l, int r, int cur, int t) {
        if (t == 11)
            return;
        if (cur > r)
            return;
        if (cur >= l)
            ans.add(cur);
        h(l, r, cur * 10 + t, t + 1);
    }
}