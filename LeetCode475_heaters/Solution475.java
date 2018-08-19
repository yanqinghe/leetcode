import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution475 {
    public static void main(String[] args) {
        Solution475 solution475 = new Solution475();
        System.out.println(solution475.findRadius(new int[]{
                282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923
        },new int[]{
                823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612

        }));
    }
    public int findRadius(int[] houses, int[] heaters) {
        int ret = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters,house);
            if(index==-1){
                ret=Math.max(ret,heaters[index+1]-house);
            }else if(index==-heaters.length-1){
                ret=Math.max(ret,house-heaters[heaters.length-1]);
            }else if(index<0){
                ret=Math.max(Math.min(heaters[-index-1]-house,house-heaters[-index-2]),ret);
            }
        }
        return ret;
    }
}
