import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution805 {
    public boolean splitArraySameAverage(int[] A) {

        int sum =0,len = A.length;
        //
        for (int i : A) {
            sum+=i;
        }
        //计算平均值
        for (int i = 1; i <=len/2 ; i++) {
            //如果如果没有办法被整除，不符合要求
            if(sum * i % len!=0) continue;
            //
            if(sum(A,sum*i/len,i,0,0,0)) return true;
        }
        return false;
    }
    private boolean sum(int[] A,int sum, int num,int start,int curSum,int curCount){
        //如果个数和总和同时到给定值，返回true
        if(curCount==num&&sum==curSum) return true;
        //如果个数达到限制，返回false
        if(curCount==num) return false;
        for (int i = start; i < A.length; i++) {
            //继续深入
            if(curSum+A[i]<=sum){
                //如果小于给定值，继续，否则，退出
                if(sum(A,sum,num,i+1,curSum+A[i],curCount+1)) return true;
            }
        }
        return false;
    }
}
