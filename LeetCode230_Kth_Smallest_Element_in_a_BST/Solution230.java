import java.util.Stack;

public class Solution230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = left(root);
        while (k>0){
            root =stack.pop();
            stack.addAll(left(root.right));
            k--;
        }
        return root.val;
    }
    Stack<TreeNode> left(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null){
            stack.add(root);
            root=root.left;
        }
        return stack;
    }

    int res = 0;
    int count =0;
    public int kthSmallest2(TreeNode root, int k) {
       count = k-1;
        dfs(root);
       return res;
    }
    private void dfs(TreeNode treeNode ){
        if(treeNode==null||count<0) return ;
        dfs(treeNode.left);
        if(count==0){
            res = treeNode.val;
            count--;
        }
        count--;
      dfs(treeNode.right);
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
