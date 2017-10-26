package LeetCode100_Same_Tree;

public class Solution100 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return help(p,q);
    }
    private boolean help(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if((p!=null&&q!=null)&&p.val==q.val){
            return help(p.left,q.left)&&help(p.right,q.right);
        }
        return false;
    }
    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
}
