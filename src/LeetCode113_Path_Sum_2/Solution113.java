package LeetCode113_Path_Sum_2;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        help(root, sum, root.val, list);
        return res;
    }

    private void help(TreeNode treeNode, int sum, int val, List<Integer> list) {
        if ((treeNode.left == null && treeNode.right == null) && val == sum) {
            res.add(new ArrayList<>(list));
        }
        //如果左边子叶为空，右边子叶不为空，那么只判断右边子叶
        if (treeNode.right != null) {
            list.add(treeNode.right.val);
            help(treeNode.right, sum, treeNode.right.val + val, list);
            list.remove(list.size() - 1);
        }
        if (treeNode.left != null) {
            list.add(treeNode.left.val);
            help(treeNode.left, sum, treeNode.left.val + val, list);
            list.remove(list.size() - 1);
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
