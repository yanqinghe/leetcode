package LeetCode2_Add_2_Numbers;

/**
 * Created by yanqinghe on 2017/7/2.
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{9};
        ListNode a0 = new ListNode(0);
        ListNode aa = a0;
        ListNode b0 = new ListNode(0);
        ListNode bb = b0;
        for (int i = 0; i < a.length; i++) {
            aa.next = new ListNode(a[i]);

            aa = aa.next;

        }
        for (int i = 0; i < b.length; i++) {
            bb.next = new ListNode(b[i]);
            bb = bb.next;
        }
        Solution2 solution = new Solution2();
        solution.addTwoNumbers(a0.next, b0.next);
    }

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

}

