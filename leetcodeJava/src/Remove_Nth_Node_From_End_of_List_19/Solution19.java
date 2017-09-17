package Remove_Nth_Node_From_End_of_List_19;

/**
 * Created by yanqinghe on 2017/7/16.
 */
public class Solution19 {
    public static void main(String[] args){
        Solution19 solution = new Solution19();
        ListNode head= new ListNode(1);
        ListNode it=head;
        int[] arr = {2};
        for(int i:arr){
            it.next=new ListNode(i);
            it=it.next;
        }
        System.out.println(solution.removeNthFromEnd(head,2));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l =head;
        int i=0;
        while(l!=null){
            l=l.next;
            i++;
        }
        if(i==n){
            return head.next;
        }
        i=i-n;
        ListNode pre = head;

        while(i>1){

            pre = pre.next;
            i--;
        }
        pre.next=pre.next.next;

        return head;
    }
}
