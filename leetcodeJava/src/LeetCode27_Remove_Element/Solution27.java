package LeetCode27_Remove_Element;
class Solution27 {
    public static void main(String[] args){
        
    }
    public int removeElement(int[] nums, int val) {
        int result =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[result]=nums[i];
            result++;
            }
        }
        return result;
    }
}