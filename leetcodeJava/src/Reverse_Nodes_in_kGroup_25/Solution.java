package Reverse_Nodes_in_kGroup_25;

/**
 * Created by hehe on 2017/7/17.
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr={1,2,3};
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for(int a:arr){
            listNode.next=new ListNode(a);
            listNode=listNode.next;
        }
        System.out.print(solution.reverseKGroup(head.next,3));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        return head;
    }
}
