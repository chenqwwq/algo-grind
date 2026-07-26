package top.chenqwwq.leetcode.contest.biweek._187._1;

public class Solution {
    public String rearrangeString(String s, char x, char y) {
        int cx = 0, cy = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == x)
                cx++;
            else if (c == y)
                cy++;
            else
                sb.append(c);
        }

        while (cy-- > 0) 
            sb.insert(0, y);
        while (cx-- > 0) 
            sb.append(x);
        return sb.toString();
    }
}