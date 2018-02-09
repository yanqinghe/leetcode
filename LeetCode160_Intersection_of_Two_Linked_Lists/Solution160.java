
public class Solution160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode point1 = headA;
        ListNode point2 = headB;
        if (point1==point2) return point1;
        while (point1!=null&&point2!=null){
            point1 = point1.next;
            point2 = point2.next;
        }
        if(point1==null){
             return  help(point1,point2,headA,headB);
        }else {
            return  help(point2,point1,headB,headA);
        }


    }
    private ListNode help(ListNode point1,ListNode point2,ListNode headA,ListNode headB){
        point1 = headB;
        if(point2==null){
            point2=headA;
        }
        if(point1==point2) return point1;
        while (point1!=point2){
            if(point1==null){
                return null;
            }
            if(point2==null){
                point2=headA;
            }
            point1=point1.next;
            point2=point2.next;
        }
        return point1;
    }

     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
}
