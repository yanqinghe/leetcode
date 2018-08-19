public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int pre =0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=1){
                max=Math.max(max,i-pre);
                pre=i+1;
            }
        }
        return  Math.max(max,nums.length-pre);
    }
}
