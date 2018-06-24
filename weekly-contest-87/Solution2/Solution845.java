import java.util.ArrayList;
import java.util.List;

public class Solution845 {
    public static void main(String[] args) {
        Solution845 solution845 = new Solution845();
        System.out.println(solution845.longestMountain(new int[]{
                0,0,1,0,0,1,1,1,1,1
        }));
    }
    public int longestMountain(int[] A) {

        if(A==null||A.length<2) return 0;
        boolean is = false;
        int len  =A.length;
        List<Integer> pos = new ArrayList<>();
        int state = 0;
        int index = 0;
        int max =0;
        for (int i = 0; i <len-1 ; i++) {
//            System.out.println(state);
            if(A[i]<A[i+1]){
                if(state==-1){
                    //如果前面是递减的，说明上一个山脉结束
                    max=Math.max(max,i-index+1);
                    index=i;
                }else if(state==0){
                    index = i;
                }
                state=1;
            }else if(A[i]>A[i+1]){
                if(state==0){
                    state=0;
                }else {
                    state=-1;
                }
            }else {
                //如果出现相同的
                if(state==-1){
                    max=Math.max(max,i-index+1);
                    index=i;
                }
                state=0;
            }
        }
        if(state==-1){
            max=Math.max(max,len-index);
        }

        return max;
    }
}
