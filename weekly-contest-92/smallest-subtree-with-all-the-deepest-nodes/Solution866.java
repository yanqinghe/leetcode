public class Solution866 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root,0);
        return ret;
    }
    TreeNode ret = null;
        int max = -1;
    int dfs(TreeNode treeNode,int lvl){
        if(treeNode==null) return lvl-1;
        int left = dfs(treeNode.left,lvl+1);
        int right = dfs(treeNode.right,lvl+1);
        if(left==right&&left>=max){
            ret=treeNode;
            max=left;
        }
        return Math.max(left,right);
    }
      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
