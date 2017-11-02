package LeetCode110_Balanced_Binary_Tree;

import java.util.Map;

public class Solution110 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public boolean isBalanced(TreeNode root) {
        if (deepth(root, 0) == -2) return false;
        return true;
    }

    private int deepth(TreeNode treeNode, int level) {
        if (treeNode != null) {
            level++;
            int left = deepth(treeNode.left, level);
            int right = deepth(treeNode.right, level);
            if (Math.abs(left - right) < 2)
                return Math.max(left, right);
            return -2;
        }
        return level;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
