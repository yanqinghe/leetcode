import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution817 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        ListNode first =head;
        int cnt = 0;
        int ret = 0;
        while (head!=null){
            if(set.contains(head.val)){
                cnt++;
            }else {
                if(cnt>0) ret++;
                cnt=0;
            }
            head=head.next;
        }
        if(cnt>0) ret++;
        return ret;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

