import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created with Hehel
 * Description:
 * User: Hehel
 * Date: 2017-12-24
 * Time: 9:53
 */
public class Solution236 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;
            if(root == p || root == q) return root;
            TreeNode l1 = lowestCommonAncestor(root.left, p, q);
            TreeNode l2 = lowestCommonAncestor(root.right, p, q);
            if(l1 !=null && l2!=null) return root;
            return l1 == null? l2 :l1;
        }

      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
