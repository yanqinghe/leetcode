package LeetCode143_Reorder_List;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution143 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        solution143.si();
    }
    public void si(){
        ListNode node= new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        reorderList(node);
        return;
    }
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode fast =head;
        ListNode slow = head;
        //利用快慢指针获取链表的中间点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转后面的链表
        fast = null;
        ListNode cur =slow.next;
        ListNode next =null;
        while (cur!=null){
            next=cur.next;
            cur.next=fast;
            fast=cur;
            cur=next;
        }
        cur =fast;

        slow.next = null;            //break 2 lists to avoid cycle
        while(cur != null && head != null){
            ListNode next1 = cur.next;
            ListNode next2 = head.next;
            cur.next = head;
            head.next = next1;
            cur = next1;
            head = next2;
        }



//        help(head,head);
        return;
    }
    private ListNode help(ListNode node, ListNode head){
        if(node==null){
            return head;
        }
        ListNode helpNode = help(node.next,head);

        if(helpNode==null){
            return null;
        }


        if(helpNode.val<node.val){
            node.next=null;
            ListNode next = helpNode.next;
            helpNode.next=node;
            node.next=next;
        }else if(helpNode.val>=node.val){
            helpNode.next=null;
            return null;
        }
        return node.next;
    }
    class ListNode {
         int val;
          ListNode next;
         ListNode(int x) { val = x; }
    }
}
