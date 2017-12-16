
import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(res,root);
        return res;
    }
    private void help(List<Integer> list,TreeNode node){
        if(node==null) return;
        list.add(node.val);
        help(list,node.left);
        help(list,node.right);
    }
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
