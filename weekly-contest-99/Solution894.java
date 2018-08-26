import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution894 {
    public static void main(String[] args) {
        Solution894 solution894 = new Solution894();
        solution894.allPossibleFBT(7);
    }
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new LinkedList<>();
        if (N % 2 == 0) {
            return result;
        }
        if (N == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode n1 : left) {
                for (TreeNode n2 : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = copyTreeNode(n1);
                    root.right = copyTreeNode(n2);
                    result.add(root);
                }
            }
        }
        return result;
    }

    private TreeNode copyTreeNode(TreeNode root){
        if(root==null) return null;
        TreeNode treeNode = new TreeNode(0);
        treeNode.left=copyTreeNode(root.left);
        treeNode.right=copyTreeNode(root.right);
        return treeNode;
    }

       class TreeNode {
          int val;
          TreeNode left;
        TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
