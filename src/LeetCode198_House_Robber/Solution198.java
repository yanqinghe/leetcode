package LeetCode198_House_Robber;

import java.util.Map;

public class Solution198 {
    public int rob(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        int [] dp = new int[nums.length+3];
        dp[0]=dp[1]=dp[2]=0;
        for (int i = 0; i < nums.length; i++) {
            dp[i+3]=Math.max(dp[i],dp[i+1])+nums[i];
        }
        return Math.max(dp[dp.length-1],dp[dp.length-2]);
    }
}
