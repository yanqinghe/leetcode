package LeetCode26_Remove_Duplicates_from_Sorted_Array;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int temp = nums[0];
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {

                temp = nums[i];
                nums[result] = nums[i];
                result++;
            }

        }
        return result;
    }
}