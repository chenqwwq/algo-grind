package top.chenqwwq.leetcode.contest.weekly._518._3;

public class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        // 速度小的右边节点会被左边的节点追上
        final int n = position.length;
        // 初筛 最开始就会被合并的
        for (int i = 0; i < n - 1; i++) {
            if (position[i + 1] - position[i] <= distance) {
                position[i] = -1;
            }
        }
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            if(position[i] == -1) continue;
           if (top == -1)
                 stack[++top] = i;
            else {
                while (top >= 0 && (speed[i] < speed[stack[top]] || position[i] - position[stack[top]] <= distance)) {
                    top--;
                }
                stack[++top] = i;
            }
        }
     
        return top+1;
    }            
}
