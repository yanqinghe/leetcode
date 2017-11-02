package LeetCode86_Partition_List;

import java.util.List;

public class Solution86 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        ListNode myhead = new ListNode(0);
        ListNode left= new ListNode(0);
        myhead.next = left;
        ListNode right = new ListNode(0);
        ListNode midHead = new ListNode(0);
        midHead.next = right;
        while(head!=null){
            ListNode node = head.next;
            if(head.val<x){
                left.next = head;
                left = left.next;
                left.next = null;
            }else {
                right.next = head;
                right = right.next;
                right.next = null;
            }
            head= node;
        }
        left.next = midHead.next.next;
        return myhead.next.next;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
