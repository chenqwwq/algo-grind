package top.chenqwwq.leetcode.contest.biweek._186._1;

class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        final int n = nums.length;
        int mid = n >> 1,cnt = 0;
        for(int num : nums){
            if(num == nums[mid]) cnt++;
        }
        return cnt == 1;
    }
}