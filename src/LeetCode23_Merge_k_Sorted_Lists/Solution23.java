package LeetCode23_Merge_k_Sorted_Lists;

/**
 * Created by hehe on 2017/7/17.
 */
public class Solution23 {
    public static void main(String[] args) {
        Solution23 solution = new Solution23();
        System.out.print("");
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        return helper(lists, 0, lists.length);
    }

    public ListNode helper(ListNode[] listNodes, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            return mergeTwoLists(helper(listNodes, l, m), helper(listNodes, m + 1, r));
        }
        return listNodes[l];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while ((l1 != null) && (l2 != null)) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 == null) {
            result.next = l2;
        } else {
            result.next = l1;
        }
        return head.next;
    }
}
