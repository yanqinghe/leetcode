package LeetCode164_Maximum_Gap;

import java.util.*;

public class Solution164 {
    public static void main(String[] args) {
        int [] a = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        Solution164 solution164 = new Solution164();
        solution164.maximumGap(a);
    }
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2) return 0;
        int max = 0,min = Integer.MAX_VALUE;
        for (int num: nums
             ) {
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int len = (max-min)/nums.length+1;
        int[][] buckets = new int[2][(max-min)/len+1];
        for (int num: nums
             ) {
            int index = (num-min)/len;
            buckets[0][index] = buckets[0][index]==0?num:Math.min(num,buckets[0][index]);
            buckets[1][index]=Math.max(num,buckets[1][index]);
        }
        int res = 0;
        int pre =min;
        for (int i = 0; i < buckets[0].length; i++) {
            if(buckets[0][i]==0&&buckets[1][i]==0){
                continue;
            }else {
                res = Math.max(res,buckets[0][i]==0?buckets[1][i]-pre:buckets[0][i]-pre);
                pre = Math.max(buckets[0][i],buckets[1][i]);
            }
        }
        return res;

    }
}
