
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode myHead = new ListNode(-10000);
        myHead.next = head;
        int v = myHead.val;
        ListNode headLast = myHead;
        while (head.next != null) {
            if (head.val == head.next.val || head.val == v) {
                //如果存在重复，那么
                v = head.val;
                headLast.next = head.next;
                head = head.next;
            } else {
                //不过不重复
                headLast = head;
                head = head.next;
            }
        }
        if (head.val == v) {
            headLast.next = head.next;
        }
        return myHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

