package top.chenqwwq.leetcode.daily._2026._20260808;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] validSequence(String word1, String word2) {
        final int n = word1.length(), m = word2.length();
        if (n < m)
            return new int[] {};
        LinkedList<Integer>[] hash = new LinkedList[26];
        for (int i = 0; i < 26; i++)
            hash[i] = new LinkedList<>();
        int[] h2 = new int[26];
        for (int i = 0; i < m; i++)
            h2[word2.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++)
            hash[word1.charAt(i) - 'a'].add(i);

        int[] ans = new int[m];
        int k = -1;
        for (int i = 0; i < m; i++) {
            char c = word2.charAt(i);
            if (hash[c - 'a'].isEmpty()) {
                ans[i] = Integer.MAX_VALUE;
                k = -1;
            } else
                ans[i] = hash[c - 'a'].removeFirst();
        }

        int[] copy = Arrays.copyOf(ans, m);
        Arrays.sort(copy);
        int target = 0;
        for (int i = 0; i < m; i++) {
            if (copy[i] != i) {
                target = i;
                break;
            }
        }
        if (k == -1)
            ans[0] = target;
        else
            ans[k] = target;
        return ans;
    }
}