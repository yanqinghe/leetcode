package LeetCode107_Binary_Tree_Level_Order_Traversal_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        help(root, 1);
        Collections.reverse(result);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    private void help(TreeNode treeNode, int level) {
        if (treeNode == null) {
            return;
        }
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }
        help(treeNode.left, level + 1);
        result.get(level - 1).add(treeNode.val);
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
