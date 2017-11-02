package LeetCode124_Binary_Tree_Maximum_Path_Sum;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.List;

public class Solution124 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        help(root, res);
        return res[0];
    }

    private int help(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = Math.max(help(root.left, res), 0);
        int right = Math.max(help(root.right, res), 0);

        int v = root.val + left + right;
        if (v > res[0]) res[0] = v;
        return root.val + Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
