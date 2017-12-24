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
        if(root==null) return null;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.add(root);
        while (!treeNodeStack.isEmpty()){
            TreeNode node = treeNodeStack.pop();
            if(node.right!=null) treeNodeStack.add(root.right);
            if(node.left!=null) treeNodeStack.add(root.left);
        }
        searchTreeNode(root,p,q,new HashSet<>(),q.val==p.val?1:2);
        return res;
    }
    boolean isEnd = false;
    TreeNode res;
    void searchTreeNode(TreeNode treeNode, TreeNode p, TreeNode q,Set<Integer> ret,int size){
        if(!isEnd&&treeNode!=null){
            if(treeNode.val==p.val||treeNode.val==q.val) ret.add(treeNode.val);
            searchTreeNode(treeNode.left,p,q,ret,size);
            searchTreeNode(treeNode.right,p,q,ret,size);
            if(!isEnd&&ret.size()==size){
                res =treeNode;
                isEnd =true;
            }
        }
    }
      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
