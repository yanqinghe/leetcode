package LeetCode111_Minimum_Depth_of_Binary_Tree;

public class Solution111 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int min = depth(root,0);
        return min;
    }
    private int depth(TreeNode treeNode,int level){
        if(treeNode!=null){
            level++;
            int left  =depth(treeNode.left,level);
            int right  = depth(treeNode.right,level);
            if(left==right)
                return left;
            else if(left==level||right==level)
                return Math.max(left,right);
            else
                return Math.min(left,right);
        }
        return level;
    }
    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
