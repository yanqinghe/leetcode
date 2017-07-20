package Reverse_Nodes_in_kGroup_25;

import java.util.List;

/**
 * Created by hehe on 2017/7/17.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2};
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for (int a : arr) {
            listNode.next = new ListNode(a);
            listNode = listNode.next;
        }
        System.out.print(solution.reverseKGroup(head.next, 2));
    }



    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode listNode = new ListNode(0);
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            if (size == k) {
                listNode.next = temp;
            }
            temp = temp.next;
        }
        if(k>size){
            return head;
        }
        temp = head;
        ListNode last=head;
        ListNode preLast = last;
        for (int i = 0; i <= size-k; i = i + k) {
            if(i>0){
                preLast =last;
            }
            last = head;
            for (int j = 1; j < k; j++) {
                System.out.print(head.val);
//                swapHeadAndIrdNode(temp, j);
                ListNode help1 = head.next;
                ListNode help2 = head;
                ListNode pre = head;
                int s = j;
                while (s > 0) {
                    pre = help2;
                    help2 = help2.next;
                    s--;
                }
                if (j > 1) {
                    pre.next=help2.next;
                    help2.next=head;
                } else {
                    head.next = help2.next;
                    help2.next = head;
                }
                head = help2;

            }
            if(i>0){
               preLast.next=head;
            }
            head = last.next;
        }
        return listNode.next;
    }

    /**
     * 函数功能，交换链表的头部和第i个元素的位置，
     * 比如（1，2，3，4）i=3
     * 交换结果为 (3,1,2,4)
     *
     * @param head 链表的头部指针
     * @param i    需要交换的元素位置
     * @return 返回交换后的头部
     */
//    public ListNode swapHeadAndIrdNode(ListNode head, int i) {
//        if (i == 0) {
//            return head;
//        }
//        ListNode temp = head.next;
//        ListNode help = head;
//        ListNode preHelp = head;
//        int s = i;
//        while (s > 0) {
//            preHelp = help;
//            help = help.next;
//            s--;
//        }
//        if (i >= 2) {
//            head.next = help.next;
//            help.next = temp;
//            preHelp.next = head;
//        } else {
//            head.next = help.next;
//            help.next = head;
//        }
//        head = help;
//        return head;
//    }
}
