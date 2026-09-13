package top.chenqwwq.leetcode.contest.biweek._190._3;

public class Solution {
    long[] cs = new long[26];
    {
        cs[0] = 1;
        for (int i = 1; i < 26; i++) {
            cs[i] = cs[i - 1] << 1;
        }
    }

    // 找到 cs 中第一个大于 num 的值
    public int f(long[] cs, int num) {
        int l = 0, r = 26;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (cs[mid] <= num)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }

    public String[] largestString(int[] nums) {
        final int n = nums.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = h(nums[i]);
        }
        return ans;
    }

    private String h(int num) {
        StringBuilder bs = new StringBuilder();
        while (num > 0) {
            // 二分找第一个大于 num 的下标，取前一个即最大不超过 num 的元素；找不到则用最后一个
            int idx = f(cs, num);
            idx = (idx == cs.length) ? cs.length - 1 : idx - 1;
            bs.append((char) ('a' + idx));
            num -= cs[idx];
        }
        return bs.toString();
    }
}