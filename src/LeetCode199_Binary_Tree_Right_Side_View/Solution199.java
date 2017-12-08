package LeetCode199_Binary_Tree_Right_Side_View;

import LeetCode2_Add_2_Numbers.ListNode;

import java.util.*;

public class Solution199 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node  =queue.poll();
            if(node.left!=null) queue2.add(node.left);
            if(node.right!=null) queue2.add(node.right);
            if(queue.isEmpty()){
                res.add(node.val);
                queue=queue2;
                queue2=new ArrayDeque<>();
            }
        }
        return res;
    }
    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
