
import java.util.*;

public class Solution740 {
    public static void main(String[] args) {
        Solution740 solution740 = new Solution740();
        int [] a = {3,4,2};
        solution740.deleteAndEarn(a);
    }
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.containsKey(i)?map.get(i)+1:1);
        }
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list);
        int one = 0,two=0,three=map.get(list.get(0))*list.get(0),four=0;

        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            if(key==list.get(i-1)+1){
                //如果相连，那么
                four =Math.max(one,two)+map.get(key)*key;
            }else {
                //如果不链接,直接累加
                four=Math.max(two,three)+map.get(key)*key;
            }
            one = two;
            two = three;
            three=four;
        }

        return Math.max(three,two);
    }
}
