package top.chenqwwq.leetcode.contest.weekly._510._1;

public class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return s(endTime) - s(startTime);
    }

    public int s(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
    }
}