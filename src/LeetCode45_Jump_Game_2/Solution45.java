package LeetCode45_Jump_Game_2;

public class Solution45 {
    public int jump(int[] nums) {
        int end = 0;
        int result = 0;
        int preEnd = 0;
        for (int i = 0; i <= end && i < nums.length; i++) {
            if (i > preEnd) {
                result++;
                preEnd = end;
            }
            end = Math.max(end, nums[i] + i);
        }
        if (end < nums.length - 1) {
            return 0;
        }
        return result;
    }
}
