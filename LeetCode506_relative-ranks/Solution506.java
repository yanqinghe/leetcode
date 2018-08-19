import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution506 {
    class P{
        int val;
        int index;

        public P(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    static String[] medals = {"Gold Medal","Silver Medal","Bronze Medal"};
    public String[] findRelativeRanks(int[] nums) {
        int index =0;
        int len =nums.length;
        P[] ps = new P[len];
        for (int num : nums) {
            ps[index]= new P(num,index++);
        }
        String[]res = new String[len];
        Arrays.sort(ps, Comparator.comparingInt(p -> -p.val));
        index=0;
        for (; index < Math.min(3,len); index++) {
            res[ps[index].index]=medals[index];
        }
        for(;index<len;index++){
            res[ps[index].index]=String.valueOf(index+1);
        }
        return res;

    }
}
