package LeetCode94_Binary_Tree_Inorder_Traversal;

import LeetCode2_Add_2_Numbers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        help(list,root);
        return list;
    }

    private void help(List<Integer> list,TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        //遍历left
        help(list,treeNode.left);
        //根节点
        list.add(treeNode.val);
        help(list,treeNode.right);
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
