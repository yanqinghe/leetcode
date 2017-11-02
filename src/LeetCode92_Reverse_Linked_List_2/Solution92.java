package LeetCode92_Reverse_Linked_List_2;

import java.util.List;

public class Solution92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    ListNode headHelp;
    ListNode node2;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        int i = 1;
        ListNode myHead = new ListNode(0);
        ListNode first = myHead;
        myHead.next = head;
        while (i < m) {
            myHead = myHead.next;
            i++;
        }

        headHelp = myHead;
        help(myHead.next, n, m);
        headHelp.next = node2;
        return first.next;
    }

    private void help(ListNode current, int n, int index) {
        ListNode next = current.next;
        current.next = null;
        if (index == n) {
            node2 = next;
            headHelp.next = current;
            headHelp = headHelp.next;
            return;
        }
        help(next, n, index + 1);
        headHelp.next = current;
        headHelp = headHelp.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
