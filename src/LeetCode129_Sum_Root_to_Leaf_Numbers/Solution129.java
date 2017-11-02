package LeetCode129_Sum_Root_to_Leaf_Numbers;

public class Solution129 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int sumNumbers(TreeNode root) {
        int[] res = {0};
        help(root, 0, res);
        return res[0];
    }

    private void help(TreeNode node, int val, int[] res) {
        if (node == null) {
            return;
        }
        node.val += val * 10;
        if (node.left == null && node.right == null) {
            res[0] += node.val;
            return;
        }
        help(node.left, node.val, res);
        help(node.right, node.val, res);
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
