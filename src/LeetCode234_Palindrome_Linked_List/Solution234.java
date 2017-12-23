import java.util.List;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针确定终点。
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast==null){
            //链表元素个数为偶数
            slow = reverseList(slow);
        }else {
            //链表元素个数为奇数
            slow= reverseList(slow.next);
        }
        while (slow!=null){
            if(head.val!=slow.val){
                return false;
            }
            slow=slow.next;
            head=head.next;
        }
        return true;
    }
    ListNode reverseList(ListNode head) {
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
     public class ListNode {
     int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
}
