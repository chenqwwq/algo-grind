package top.chenqwwq.leetcode.daily._2026._20260721;

public class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        if (s == null || s.isBlank())
            return 0;
        s = '1' + s + '1';  
        final int n = s.length();
        int ans = 0, len = 0;
        int pre = -1, m0 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ans++;
                if (len != 0) {
                    if (pre != -1)
                        m0 = Math.max(m0, pre + len);
                    pre = len;
                    len = 0;
                }
            } else if (s.charAt(i) == '0') {
                len++;
            }
        }

        return ans + m0 - 2;
    }
}