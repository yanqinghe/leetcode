public class Solution687 {
    public int longestUnivaluePath(TreeNode root) {
        if(root!=null)dfs(root,root.val-1);
        return max;
    }
    int max = 0;
    private int dfs(TreeNode root,int v){
        if(root==null) return 0;
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        int cnt  = left+right;
        int ret = Math.max(left,right);
        max=Math.max(Math.max(ret,cnt),max);
        if(root.val==v) {
            System.out.println("ret"+ret);
            return ret+1;
        }else {
            System.out.println(0);
            return 0;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
