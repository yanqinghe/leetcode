
/**
 * Created with Hehel
 * Description:
 * User: Hehel
 * Date: 2017-12-24
 * Time: 9:45
 */
public class Solution235 {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        searchTreeNode(root,p,q);
        return res;
    }
    void searchTreeNode(TreeNode treeNode,TreeNode p,TreeNode q){
        if(p.val>treeNode.val&&q.val>treeNode.val){
            //如果两者都在右子树
            searchTreeNode(treeNode.right,p,q);
        }else if(p.val<treeNode.val&&q.val<treeNode.val){
            //如果两者都在作子树
            searchTreeNode(treeNode.left,p,q);
        }else {
            //如果两者分开，说明当前节点就是最小公共祖先节点
            res = treeNode;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
