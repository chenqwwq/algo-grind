package top.chenqwwq.leetcode.contest.weekly._511._2;

import top.chenqwwq.leetcode.common.TreeNode;

public class Solution {

    int ans = 0;

    public int countDominantNodes(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return -1;
        int l = dfs(node.left), r = dfs(node.right);
        if (node.val >= l && node.val >= r)
            ans++;
        return Math.max(node.val, Math.max(l, r));
    }
}