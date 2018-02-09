
import java.util.ArrayList;
import java.util.List;

public class Solution116 {
    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     * int val;
     * TreeLinkNode left, right, next;
     * TreeLinkNode(int x) { val = x; }
     * }
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root;
        root.next = null;
        while (node.left != null && node.right != null) {
            TreeLinkNode cNode = node;
            while (cNode != null) {
                cNode.left.next = cNode.right;
                cNode.right.next = cNode.next == null ? null : cNode.next.left;
                cNode = cNode.next;
            }
            node = node.left;
        }
//        help(root,0);
    }

    List<TreeLinkNode> nodeList = new ArrayList<>();

    private void help(TreeLinkNode root, int lev) {
        if (root == null) {
            return;
        }
        if (nodeList.size() <= lev) {
            nodeList.add(root);
        } else {
            nodeList.get(lev).next = root;
            nodeList.set(lev, root);
        }
        help(root.left, lev + 1);
        help(root.right, lev + 1);
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
