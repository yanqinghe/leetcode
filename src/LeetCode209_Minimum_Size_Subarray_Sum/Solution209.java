package LeetCode209_Minimum_Size_Subarray_Sum;

public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int left=0,right=0;
        int len = nums.length;
        int sum =0,res =  len + 1;
        while (right<len){
            while (sum<s&&right<len){
                sum+=nums[right++];
            }
            while (sum>=s){
                res = Math.min(res,right-left);
                sum-=nums[left++];
            }
        }
        return res ==len +1?0:res;
    }
}
