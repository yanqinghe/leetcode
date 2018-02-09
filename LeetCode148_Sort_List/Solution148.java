
public class Solution148 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode sortList(ListNode head) {
       if(head==null)return null;
        return help(head);
    }
    private ListNode help(ListNode node){
        if(node.next==null) return node;
        ListNode slow = node;
        ListNode fast =node;
        ListNode preSlow = node;
        while (fast!=null&&fast.next!=null){
            fast =fast.next.next;
            preSlow= slow;
            slow =slow.next;
        }
        preSlow.next=null;
        fast = help(node);
        slow = help(slow);
        node = new ListNode(0);
        ListNode res = node;

        while (slow!=null&&fast!=null){
            if(slow.val<fast.val){
                node.next=slow;
                slow=slow.next;
            }else {
                node.next = fast;
                fast = fast.next;
            }
            node=node.next;
        }
        if(slow!=null){
            node.next=slow;
        }else {
            node.next=fast;
        }
        return res.next;
    }

     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
