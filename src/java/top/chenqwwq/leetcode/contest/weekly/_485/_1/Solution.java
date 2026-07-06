package top.chenqwwq.leetcode.contest.weekly._485._1;

/**
 * @author chenqwwq
 * @date 2026/1/18
 **/
public class Solution {
    public int vowelConsonantScore(String s) {
        int c = 0, v = 0;
        for (char cc : s.toCharArray()) {
            if (cc == ' ') continue;
            if (cc >= '0' && cc <= '9') continue;
            if (cc == 'a' || cc == 'e' || cc == 'i' || cc == 'o' || cc == 'u') v++;
            else c++;
        }
        return c > 0 ? v / c : c;
    }
}