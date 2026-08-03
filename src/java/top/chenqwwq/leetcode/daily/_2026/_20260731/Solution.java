package top.chenqwwq.leetcode.daily._2026._20260731;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int minimumPushes(String word) {
        int[] hash = new int[26];
        for (char c : word.toCharArray()) {
            hash[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        for (int num : hash) {
            if (num == 0)
                continue;
            list.add(num);
        }

        list.sort((a, b) -> b - a);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            ans += (list.get(i) * ((i / 8) + 1));
        }
        return ans;
    }
}