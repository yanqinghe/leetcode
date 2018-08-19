import java.util.Stack;

public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,false);
        return cnt;
    }

    int cnt =0;
    private void dfs(TreeNode root,boolean isLeft){
        if(root==null) return;
        if(root.left==null&&root.right==null&&isLeft){
            cnt+=root.val;
        }else {
            dfs(root.left,true);
            dfs(root.right,false);
        }
    }
      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
