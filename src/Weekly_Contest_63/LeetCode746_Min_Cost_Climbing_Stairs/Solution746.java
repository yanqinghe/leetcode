package LeetCode746_Min_Cost_Climbing_Stairs_My_SubmissionsBack_to_Contest;

public class Solution746 {
    public static void main(String[] args) {
        Solution746 solution_746 = new Solution746();
        System.out.print(solution_746);
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null||cost.length<1 )return 0;
        int[] dp = new int[cost.length+1];
        dp[1]=cost[0];
        for (int i = 1; i < cost.length; i++) {
            dp[i+1]=Math.min(dp[i],dp[i-1])+cost[i];
        }
        return Math.min(dp[cost.length],dp[cost.length-1]);
    }
}
