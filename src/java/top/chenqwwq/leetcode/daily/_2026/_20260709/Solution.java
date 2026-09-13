package top.chenqwwq.leetcode.daily._2026._20260709;

public class Solution {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // 并查集解决
        int[] pp = new int[n];
        int t = 0;
        pp[0] = t;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] > maxDiff) {
                pp[i + 1] = ++t;
                continue;
            }
            pp[i + 1] = t;
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = pp[queries[i][0]] == pp[queries[i][1]];
        }
        return ans;
    }
}