import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution264 {
    public static void main(String[] args) {
        Solution264 solution264 = new Solution264();
        solution264.nthUglyNumber(123);
    }
    public int nthUglyNumber(int n) {
        int [] array = {1,1,1};
        int [] uglyArray = new int[n+1];
        uglyArray[1]=1;
        int count = 1;
        while (count<n){
            int num2 = uglyArray[array[0]] *2;
            int num3 = uglyArray[array[1]] *3;
            int num5 = uglyArray[array[2]] *5;
            count++;
            uglyArray[count]=Math.min(num2,Math.min(num3,num5));
            //这里要注意有可能重复出现某个元素，那么需要把重复的部分跳过
            if(uglyArray[count]==num2){
                array[0]++;
            }
            if(uglyArray[count]==num3){
                array[1]++;
            }
            if(uglyArray[count]==num5) array[2]++;

        }
        return uglyArray[count];

    }
}
