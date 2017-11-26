package LeetCode142_Linked_List_Cycle_2;


public class Solution142 {
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
    public static void main(String[] args) {
        Solution142 solution142 = new Solution142();

        solution142.help();
    }
    private void help(){
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next= listNode;
        detectCycle(listNode);
    }
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean is = false;
        while (fast != null) {
            fast = fast.next;
            if (is) {
                slow = slow.next;
                is = false;
                if(fast == slow){
                    slow=head;
                    while (slow!=fast){
                        slow=slow.next;
                        fast=fast.next;
                    }
                    return slow;
                }
            } else is = true;
        }
        return null;
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
