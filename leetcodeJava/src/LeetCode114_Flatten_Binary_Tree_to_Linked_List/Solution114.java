package LeetCode114_Flatten_Binary_Tree_to_Linked_List;

import java.util.List;

public class Solution114 {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        help(root);
    }
    private TreeNode help(TreeNode treeNode){
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        TreeNode rl =treeNode;

        if(treeNode.left!=null){
            TreeNode ll = help(treeNode.left);
            rl = ll;
            ll.right=right;
            treeNode.right=left;
            treeNode.left =null;           
        }
        if(right!=null){
            rl = help(right);
        }
        return rl;

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
