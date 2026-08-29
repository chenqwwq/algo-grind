package top.chenqwwq.leetcode.contest.biweek._189._1;

public class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int cur = 0;
        int ans = 0;
        for(int num : requests){
            ans += Math.abs(num - cur);
            cur = num;
        }       
        return ans;
    }
}