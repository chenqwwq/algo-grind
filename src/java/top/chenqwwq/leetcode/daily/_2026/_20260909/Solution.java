package top.chenqwwq.leetcode.daily._2026._20260909;

import top.chenqwwq.leetcode.common.TreeNode;

public class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[] { 0, 0 };
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        if (node.val == (l[1] + r[1] + node.val) / (l[0] + r[0] + 1)) {
            ans++;
        }
        return new int[] { l[0] + r[0] + 1, r[1] + l[1] + node.val };
    }
}