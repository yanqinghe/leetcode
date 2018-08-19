import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution869 {
    public static void main(String[] args) {
        Solution869 solution869 = new Solution869();
        System.out.println(solution869.reorderedPowerOf2(26038888));
        System.out.println(solution869.reorderedPowerOf2(10));
        System.out.println(solution869.reorderedPowerOf2(1));
        System.out.println(solution869.reorderedPowerOf2(16));
        System.out.println(solution869.reorderedPowerOf2(46));

        System.out.println(solution869.reorderedPowerOf2(24));

    }
    public boolean reorderedPowerOf2(int N) {
        int[] arr = new int[10];
        int temp = N;
        int len =0;
        while (temp>0){
            int i = temp%10;
            if(arr[i]==-1){
                arr[i]=0;
            }
            arr[i]++;
            temp/=10;
            len++;
        }

        return help(0,arr,0,len);
    }
    boolean help(long num,int[] arr,int index,int length){
        if(index==length){
            if((num&num-1)==0)
                return true;
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if(num==0&&i==0||arr[i]==0) continue;
            arr[i]--;
            if(help(num*10+i,arr,index+1,length))
                return true;
            arr[i]++;
        }
        return false;
    }
    private boolean equ(int i1,int[] arr){
        int[] temp = new int[10];
        Arrays.fill(temp,-1);
        while (i1>0){
            int i = i1%10;
            if(temp[i]==-1){
                temp[i]=0;
            }
            temp[i1%10]++;
            i1/=10;
        }
        for (int i = 0; i < 10; i++) {
            if(temp[i]!=arr[i]) return false;
        }
        return true;
    }
}
