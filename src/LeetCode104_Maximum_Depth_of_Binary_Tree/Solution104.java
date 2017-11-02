package LeetCode104_Maximum_Depth_of_Binary_Tree;

public class Solution104 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    private  int max;
    public int maxDepth(TreeNode root) {
        help(root,1);
        return max;
    }
    private void help(TreeNode root,int level){
        if(root==null){
            return;
        }
        max=max<level?level:max;
        help(root.left,level+1);
        help(root.right,level+1);
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
