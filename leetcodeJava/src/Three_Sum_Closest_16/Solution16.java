package Three_Sum_Closest_16;

import java.util.Arrays;

/**
 * Created by hehe on 2017/7/13.
 */
public class Solution16 {
    public static void main(String[] args){
        Solution16 solution = new Solution16();
        int[] ints = {0,2,1,-3};
        System.out.print(solution.threeSumClosest(ints,1));
    }
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int minDelta=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int delta = nums[i]+nums[left]+nums[right]-target;
                if(delta==0){
                    return target;
                }else if(delta>0){
                    right--;
                }else {
                    left++;
                }
                if(Math.abs(delta)<Math.abs(minDelta)){
                    minDelta=delta;
                }



            }
        }
        return target+minDelta;
    }
}
