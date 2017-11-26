package LeetCode145_Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    public static void main(String[] args) {
        Stack<String> stack  = new Stack<>();
        stack.add(null);
        stack.add("1111");
        return;
    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
                Stack<TreeNode> stack =new Stack<>();
        stack.add(root);
        res.add(root.val);
        while (!stack.isEmpty()){
            //首先获取最上面的值
            TreeNode node =stack.peek();
            if(node.right==null){
                //如果右分支为空
                if(node.left==null){
                    //左分支也为空
                    stack.pop();
                }else {
                    stack.add(node.left);
                    node.left=null;
                    res.add(node.left.val);
                }
            }else {
                stack.add(node.right);
                res.add(node.right.val);
                node.right=null;
            }
        }
        Collections.reverse(res);
        return res;
    }



     public class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
