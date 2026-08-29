package top.chenqwwq.leetcode.contest.weekly._515._2;

import java.util.Arrays;

public class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        final int n = lights.length, m = arrivalTime.length;
        int ans = -1;
        Arrays.sort(lights);
        for (int num : arrivalTime) {
            int t = num % period;
            if (t >= lights[n - 1]) {
                ans = Math.max(ans, period - t);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().minPenalty(8, new int[]{2,3}, new int[]{2,5,8,11});
    }
}