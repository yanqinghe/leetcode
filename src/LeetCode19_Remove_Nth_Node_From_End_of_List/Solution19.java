
/**
 * Created by yanqinghe on 2017/7/16.
 */
public class Solution19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head;
        int i = 0;
        while (l != null) {
            l = l.next;
            i++;
        }
        if (i == n) {
            return head.next;
        }
        i = i - n;
        ListNode pre = head;

        while (i > 1) {

            pre = pre.next;
            i--;
        }
        pre.next = pre.next.next;

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
