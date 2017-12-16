
import java.util.ArrayList;
import java.util.List;

public class Solution103 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        help(root, 1);
        return result;
    }

    private void help(TreeNode treeNode, int level) {
        if (treeNode == null) return;
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }

        help(treeNode.left, level + 1);

        if ((level & 1) == 1) {
            result.get(level - 1).add(treeNode.val);
        } else {
            result.get(level - 1).add(0, treeNode.val);
        }
        help(treeNode.right, level + 1);
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
