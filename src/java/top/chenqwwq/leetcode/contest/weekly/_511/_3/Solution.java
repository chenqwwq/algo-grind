package top.chenqwwq.leetcode.contest.weekly._511._3;

public class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int[] cs = new int[2];
        for (char c : s.toCharArray())
            cs[c - '0']++; // 统计 0、1 各自的数量

        final int n = strs.length;
        boolean[] ans = new boolean[n];
        outer: for (int i = 0; i < n; i++) {
            String word = strs[i];
            int[] ts = new int[2]; // 统计 0、1 各自的数量
            for (char c : word.toCharArray()) {
                if (c != '?') {
                    ts[c - '0']++;
                }
            }
            if (ts[0] > cs[0] || ts[1] > cs[1]) {
                continue;
            }

            int d0 = cs[0] - ts[0];
            int c0 = 0, c1 = 0; // c0 表示原始的 0，c1 表示转换后的 0，c0 要小于等于 c2
            for (int j = 0; j < word.length(); j++) {
                if (s.charAt(j) == '0')
                    c0++;
                if (word.charAt(j) == '0' || (word.charAt(j) == '?' && d0-- > 0))
                    c1++;
                if (c1 < c0) {
                    ans[i] = false;
                    continue outer;
                }
            }
            ans[i] = true;
        }
        return ans;
    }
}