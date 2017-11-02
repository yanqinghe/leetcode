package LeetCode141_Linked_List_Cycle;

import java.util.List;

public class Solution141 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        boolean is = false;
        while (fast != null) {
            fast = fast.next;
            if (is) {
                slow = slow.next;
                is = false;
            } else is = true;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
