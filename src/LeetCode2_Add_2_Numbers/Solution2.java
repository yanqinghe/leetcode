/**
 * Created by yanqinghe on 2017/7/2.
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentl1 = l1;
        ListNode currentl2 = l2;
        ListNode result = new ListNode(0);
        ListNode resultNext = result;
        ListNode kongNode = new ListNode(0);
        int op = 0;
        while (currentl1 != kongNode || currentl2 != kongNode) {
            int opResult = currentl1.val + currentl2.val + op;
            if (opResult >= 10) {
                result.next = new ListNode(opResult - 10);
                op = 1;
            } else {
                result.next = new ListNode(opResult);
                op = 0;
            }
            currentl1 = currentl1.next == null ? kongNode : currentl1.next;
            currentl2 = currentl2.next == null ? kongNode : currentl2.next;
            result = result.next;
        }
        if (op == 1) {
            result.next = new ListNode(1);
        }
        return resultNext.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}

