
/**
 * Created by hehe on 2017/7/17.
 */
public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        int i = 0;
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode pre = temp;
        while (!(temp.next == null || temp.next.next == null)) {
            i++;
            temp = temp.next;
            if (i % 2 == 1) {
                ListNode a = temp.next;
                temp.next = temp.next.next;
                a.next = temp;
                pre.next = a;
            }
            pre = temp;
            i++;
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
