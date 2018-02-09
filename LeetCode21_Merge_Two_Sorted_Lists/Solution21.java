package LeetCode21_Merge_Two_Sorted_Lists;

/**
 * Created by hehe on 2017/7/17.
 */
public class Solution21 {

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
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}