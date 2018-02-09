
import java.util.List;

public class Solution147 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        Solution147 solution147   = new Solution147();

        solution147.help();
    }
    private void help(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next=new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next= new ListNode(5);

        insertionSortList(head);
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode node = new ListNode(0);
        node.next =head;
        if(node.next==null) return head;
        ListNode next;
        ListNode preNode =head;
        while (head!=null){
           next=head.next;
           ListNode h = node.next;
           ListNode pre= node;
           while (h!=head){
               if(head.val<h.val){
                   insert(pre,head);
                   preNode.next=next;
                   break;
               }
               pre=h;
               h=h.next;
           }
           if(h==head) preNode=h;
           head=next;
        }
        return node.next;
    }
    private void insert(ListNode pre,ListNode insertNode){
        insertNode.next=pre.next;
        pre.next=insertNode;
    }
    public class ListNode {
          int val;
         ListNode next;
          ListNode(int x) { val = x; }
     }
}
