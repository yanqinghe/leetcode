package Merge_Two_Sorted_Lists_21;

/**
 * Created by hehe on 2017/7/17.
 */
public class Solution21 {
    public static void  main(String[] args){
        Solution21 solution = new Solution21();
        int a[]={};
        int b[]={};
        ListNode l1=new ListNode(0);
        ListNode lh1=l1;
        ListNode l2 =new ListNode(0);
        ListNode lh2=l2;
        for(int aa:a){
            l1.next=new ListNode(aa);
            l1=l1.next;
        }
        for(int bb:b){
            l2.next=new ListNode(bb);
            l2=l2.next;
        }
        System.out.print(solution.mergeTwoLists(lh1.next,lh2.next));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while((l1!=null) &&(l2!=null)){
            if(l1.val<l2.val){
                result.next=l1;
                l1=l1.next;
            }else{
                result.next=l2;
                l2=l2.next;
            }
            result=result.next;
        }
        if(l1==null){
            result.next=l2;
        }else{
            result.next=l1;
        }
        return head.next;
    }
}