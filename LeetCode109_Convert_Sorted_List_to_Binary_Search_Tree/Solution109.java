
public class Solution109 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode helpHead = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        int[] nums = new int[len];
        int i = 0;
        while (helpHead != null) {
            nums[i++] = helpHead.val;
            helpHead = helpHead.next;
        }

        return help(nums, 0, len - 1);
    }

    private TreeNode help(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, l, mid - 1);
        root.right = help(nums, mid + 1, r);
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
