package top.chenqwwq.leetcode.contest.weekly._509._2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Boolean> memo;

    public boolean canMakeSubsequence(String s, String t) {
        memo = new HashMap<>();
        final int n = s.length(), m = t.length();
        if (n > m)
            return false;
        if (s.equals(t))
            return true;
        return h(s, t, 0, 0, 1);
    }

    private int gk(int i, int j, int flag) {
        return (i << 16) | (j << 8) | flag;
    }

    private boolean h(String s, String t, int i, int j, int flag) {
        int key = gk(i, j, flag);
        if (memo.containsKey(key))
            return memo.get(key);
        boolean res;
        if (i >= s.length())
            res = true;
        else if (j >= t.length())
            res = false;
        else if (s.charAt(i) == t.charAt(j))
            res = h(s, t, i + 1, j + 1, flag);
        else {
            res = (flag == 1 ? h(s, t, i + 1, j + 1, 0) || h(s, t, i, j + 1, 1) : h(s, t, i, j + 1, 0));
        }
        memo.put(key, res);
        return res;
    }
}