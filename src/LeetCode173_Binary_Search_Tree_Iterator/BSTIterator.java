package LeetCode173_Binary_Search_Tree_Iterator;

import LeetCode2_Add_2_Numbers.ListNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while (root!=null){
            stack.add(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        TreeNode res  = current;
        current =current.right;
        while (current!=null){
            stack.push(current);
            current = current.left;
        }
        return res.val;
    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
