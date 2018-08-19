public class Solution94_1 {
    public static void main(String[] args) {
        Solution94_1 solution94_1 = new Solution94_1();
        System.out.println('s');
    }
     class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs(root1,sb1);
        dfs(root2,sb2);
        return sb1.toString().equals(sb2.toString());
    }
    private void dfs(TreeNode node,StringBuilder sb){
        if(node.left==null&&node.right==null){
            sb.append(node.val).append(';');
        }
        if(node.left!=null){
            dfs(node.left,sb);
        }
        if(node.right!=null){
            dfs(node.right,sb);
        }
    }
}
