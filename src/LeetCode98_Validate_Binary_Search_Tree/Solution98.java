package LeetCode98_Validate_Binary_Search_Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return(help(root.left, root.val,Long.MIN_VALUE)
                && help(root.right, Long.MAX_VALUE,root.val));
    }

    private boolean help(TreeNode treeNode, long minV,long maxV) {
        if (treeNode == null) {
            return true;
        }
        if(treeNode.val < minV&&treeNode.val>maxV){
            return (help(treeNode.left, treeNode.val,maxV)
                    && help(treeNode.right, minV,treeNode.val));

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
