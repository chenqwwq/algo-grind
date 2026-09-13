package top.chenqwwq.leetcode.contest.weekly._519._3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public long shadowPairs(int[] nums) {
        final int n = nums.length;
        Stack<Integer> stack = new Stack<>(); // 单调递增数组
        Map<Integer, Integer> cs = new HashMap<>();

        long ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int idx = stack.pop();
                int cnt = cs.get(nums[idx]);
                cs.put(nums[idx], cnt - 1);
                ans += stack.size() - cnt + 1;
            }
            stack.push(i);
            cs.put(nums[i], cs.getOrDefault(nums[i], 0) + 1);
        }

        while (stack.size() > 1) {
            int idx = stack.pop();
            int cnt = cs.get(nums[idx]);
            cs.put(nums[idx], cnt - 1);
            ans += stack.size() - cnt + 1;
        }
        return ans;
    }
}