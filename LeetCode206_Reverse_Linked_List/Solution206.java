
import java.util.Stack;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        //如果为空
        if(head==null) return head;
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;

    }
    public ListNode reverseList2(ListNode head) {
        if(head==null) return head;
        return df(head);
    }
    ListNode df(ListNode node){
        if(node.next==null){
            return node;
        }
        ListNode nextNode = node.next;
        node.next = null;
        ListNode lastNode = df(nextNode);
        nextNode.next=node;
        return lastNode;
    }
      class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
