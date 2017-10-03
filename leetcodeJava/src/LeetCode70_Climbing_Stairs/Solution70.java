package LeetCode70_Climbing_Stairs;

public class Solution70 {
    public int climbStairs(int n) {
        int [] dp= new int[2];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i&1]+=dp[(i+1)&1];
        }
        return dp[n&1];
    }
}

