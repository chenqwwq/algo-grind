package top.chenqwwq.leetcode.daily._2026._20260716;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public long gcdSum(int[] nums) {
        final int n = nums.length;
        List<Integer> dq = new LinkedList<>();
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            dq.addLast(gcd(max, nums[i]));
        }
        long ans = 0;
        dq.sort((a, b) -> a - b);
        while (dq.size() >= 2) {
            ans += gcd(dq.remove(0), dq.remove(dq.size() - 1));
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}