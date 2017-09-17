package Swap_Nodes_in_Pairs_24;

/**
 * Created by hehe on 2017/7/17.
 */
public class Solution24 {
    public static void main(String[] args){
        Solution24 solution= new Solution24();
        int[] arr={1,2,3};
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for(int a:arr){
            listNode.next=new ListNode(a);
            listNode=listNode.next;
        }
        System.out.print(solution.swapPairs(head.next));
    }
    public ListNode swapPairs(ListNode head) {
        int i=0;
        ListNode temp = new ListNode(0);
        temp.next =head;
        head=temp;
        ListNode pre = temp;
        while(!(temp.next==null||temp.next.next==null)){
            i++;
            temp=temp.next;
            if(i%2==1){
                ListNode a = temp.next;
                temp.next =temp.next.next;
                a.next =temp;
                pre.next=a;
            }
            pre=temp;
            i++;
        }
        return head.next;
    }
}
