
public class Solution99 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    TreeNode mistakeNode1;
    TreeNode mistakeNode2;

    TreeNode pre;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        searchMistake(root);
        int vTemp = mistakeNode1.val;
        mistakeNode1.val = mistakeNode2.val;
        mistakeNode2.val = vTemp;

    }

    private void searchMistake(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        searchMistake(treeNode.left);
        if (pre != null && treeNode.val <= pre.val) {
            if (mistakeNode1 == null) {
                mistakeNode1 = pre;
            }
            mistakeNode2 = treeNode;
        }
        pre = treeNode;
        searchMistake(treeNode.right);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
