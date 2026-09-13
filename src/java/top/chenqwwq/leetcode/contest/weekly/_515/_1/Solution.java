package top.chenqwwq.leetcode.contest.weekly._515._1;

public class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int dis = Integer.MAX_VALUE, ans = -1;
        for (int i = 0;i < drones.length;i++){
            int[] ns = drones[i];
            int cd = Math.abs(ns[0] - target[0]) + Math.abs(ns[1] - target[1]);
            if(cd <= ns[2] && dis > cd){
                dis = cd;
                ans = i;
            }
        }
        return ans;
    }
}