package LeetCode153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution153 {
    public int findMin(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        int left = 0,right = nums.length-1;
        while (left<right){
            if(nums[left]>nums[right]){
                int mid = left+right>>1;
                if(nums[mid]>nums[left]){
                    left=mid+1;
                }else if(nums[mid]<nums[right]){
                    right=mid;
                }else break;
            }else {
                return nums[left];
            }

        }
        return nums[right];
    }
}
