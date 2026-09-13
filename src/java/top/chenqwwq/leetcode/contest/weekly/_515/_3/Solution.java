package top.chenqwwq.leetcode.contest.weekly._515._3;

public class Solution {
    public int maximumGap(String a, String b) {
        if (a.length() < 2)
            return 0;

        // 对于每一个 a 下标，找到其能满足的最晚一个 b 下标
        final int n = a.length(), m = b.length();
        int[] lastValid = new int[n];
        for (int i = m - 1, j = n - 1; i >= 0; i--) {
            if (a.charAt(j) == b.charAt(i)) {
                lastValid[j--] = i;
                if (j < 0)
                    break;
            }
        }
        int ans = 0;
        for (int i = 0, j = 0; i < m && j < n - 1; i++) {
            if (b.charAt(i) == a.charAt(j)) {
                ++j;
                ans = Math.max(ans, lastValid[j] - i);
            }
        }
        return ans;
    }
}