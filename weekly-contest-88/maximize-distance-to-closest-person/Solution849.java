import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution849 {
    public static void main(String[] args) {
        Solution849 solution849 = new Solution849();
        System.out.println(solution849.maxDistToClosest(new int[]{
                0,1
        }));
    }
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] help1 = new int[len];
        int[] help2 = new int[len];
        int index =-20000;
        for (int i = 0; i < len; i++) {
            if(seats[i]==1){
                index=i;
            }else {
                help1[i]=i-index;
            }
        }
        index=20000;
        for (int i = len-1; i >= 0; i--) {
            if(seats[i]==1){
                index=i;
            }else {
                help2[i]=index-i;
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max=Math.max(Math.min(help1[i],help2[i]),max);
        }
        return max;
    }
}
