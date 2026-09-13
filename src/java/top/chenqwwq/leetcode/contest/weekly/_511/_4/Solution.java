package top.chenqwwq.leetcode.contest.weekly._511._4;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minimumGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String w : words) {
            StringBuilder evens = new StringBuilder();
            StringBuilder odds = new StringBuilder();
            for (int i = 0; i < w.length(); i++) {
                if (i % 2 == 0) {
                    evens.append(w.charAt(i));
                } else {
                    odds.append(w.charAt(i));
                }
            }
            String minE = getMinCyclic(evens.toString());
            String minO = getMinCyclic(odds.toString());
            set.add(minE + "#" + minO);
        }
        return set.size();
    }

    private String getMinCyclic(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        int i = 0, j = 1, k = 0;
        while (i < n && j < n && k < n) {
            char ci = s.charAt((i + k) % n);
            char cj = s.charAt((j + k) % n);
            if (ci == cj) {
                k++;
            } else {
                if (ci > cj) {
                    i += k + 1;
                } else {
                    j += k + 1;
                }
                if (i == j) {
                    j++;
                }
                k = 0;
            }
        }
        int start = Math.min(i, j);
        return s.substring(start) + s.substring(0, start);
    }
}