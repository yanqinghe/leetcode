package LeetCode55_Jump_Game;

public class Solution55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int end = 0;
        for (int i = 0; i <= end && i < nums.length; i++) {
            //如果当前的
            end = Math.max(i + nums[i], end);
        }
        if (end != nums.length - 1) {
            return false;
        }
        return true;
    }

}

