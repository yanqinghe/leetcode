package LeetCode95_Unique_Binary_Search_Trees_2;

import LeetCode2_Add_2_Numbers.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return help(1, n);
    }

    private List<TreeNode> help(int l, int r) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTree = help(l, i - 1);
            List<TreeNode> rightTree = help(i + 1, r);
            for (TreeNode left : leftTree
                    ) {
                for (TreeNode right : rightTree
                        ) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    res.add(treeNode);
                }
            }
        }
        return res;
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
