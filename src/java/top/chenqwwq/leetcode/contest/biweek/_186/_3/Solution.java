package top.chenqwwq.leetcode.contest.biweek._186._3;

public class Solution {
    public int minOperations(String s1, String s2) {
        if(s1 == null ? s2 == null : s1.equals(s2)) return 0;
        if("1".equals(s1) && "0".equals(s2)) return -1;
        final int n = s1.length()+1;
        s1 = '0' + s1;s2 = '0' + s2;
        int[] dp = new int[n];
        dp[0] = s1.charAt(0) == s2.charAt(0) ? 0 : 1;
        for(int i = 1;i < n;i++){
            if(s1.charAt(i) == s2.charAt(i)) dp[i] = dp[i-1];
            else{
                if(s1.charAt(i) == '0') dp[i] = dp[i-1]+1;
                else{ // 当前列是 1、0，根据前一列决定
                    int t = 0;
                    if(s1.charAt(i-1) == '0'){
                        if(s2.charAt(i-1) == '0') t = 2;
                        else t = 3;
                    }else{
                        if(s2.charAt(i-1) == '0') t = 1;
                        else t = 2;
                    }
                    dp[i] = (i > 1 ? dp[i-2] : 0) + t;
                }
            }
        }
        return dp[n-1];
    }
}