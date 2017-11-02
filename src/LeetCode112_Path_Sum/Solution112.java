package LeetCode112_Path_Sum;

public class Solution112 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dp(root, sum, 0);
    }

    private boolean dp(TreeNode treeNode, int sum, int val) {
        if (treeNode == null) {
            if (val == sum)
                return true;
            return false;
        }
        treeNode.val += val;
        //如果左边子叶为空，右边子叶不为空，那么只判断右边子叶
        if (treeNode.left == null && treeNode.right != null) {
            return dp(treeNode.right, sum, treeNode.val);
        }
        //如果右边子叶为空，左边子叶不为空，那么只判断左边子叶
        if (treeNode.right == null && treeNode.left != null) {
            return dp(treeNode.left, sum, treeNode.val);
        }
        //如果两者都不为空，或者两者都为空
        return dp(treeNode.left, sum, treeNode.val) || dp(treeNode.right, sum, treeNode.val);
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
