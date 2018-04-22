import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution822 {
    public static void main(String[] args) {
        Solution822 solution822 = new Solution822();
        System.out.println(solution822.flipgame(new int[]{1,2,4,4,7},new int[]{1,3,4,1,3}));
    }
    public int flipgame(int[] fronts, int[] backs) {

        Set<Integer> set = new HashSet<>();
        int ret= Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length ; i++) {
            if(fronts[i]!=backs[i]){

            }else {
                set.add(fronts[i]);
            }
        }
        for (int front : fronts) {
            if(!set.contains(front))  ret=Math.min(ret,front);
        }
        for (int back : backs) {
            if(!set.contains(back))  ret=Math.min(ret,back);
        }
        return ret==Integer.MAX_VALUE?0:ret;
    }
}
