
public class Solution101 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    private boolean help(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == rightNode) {
            return true;
        }
        if (leftNode != null && rightNode != null) {
            if (leftNode.val == rightNode.val) {
                return help(leftNode.left, rightNode.right) && help(leftNode.right, rightNode.left);
            }
        }
        return false;
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
