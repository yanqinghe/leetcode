package LeetCode80_Remove_Duplicates_from_Sorted_Array_2;

public class Solution80{
      public int removeDuplicates(int[] nums) {
          if (nums==null||nums.length<1){
              return 0;
          }
        int d =1;
        int result =1;
        for(int i =1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                //如果不是重复的
                d=1;
                nums[result]=nums[i];
                result++;
            }else {
                //如果是重复的
                if(d<2){
                    d++;
                    nums[result]=nums[i];
                    result++;
                }
            }
        }
        return result;
    }
}