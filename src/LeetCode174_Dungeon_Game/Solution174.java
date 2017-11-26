package LeetCode174_Dungeon_Game;

public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        //利用动态规划保存记录
        int [][] dp = new int[m][n];
        //关键点就是从后往前遍历，首先记录最后个位置需要保证多少血，骑士血最少为1，所以与1进行比较，取最大值
        dp[m-1][n-1]=Math.max(-dungeon[m-1][n-1]+1,1);
        for (int i = n-2; i >=0; i--) {
            dp[m-1][i] = Math.max(dp[m-1][i+1]-dungeon[m-1][i],1);
        }
        for (int i = m-2; i >=0; i--) {
            dp[i][n-1]=Math.max(dp[i+1][n-1]-dungeon[i][n-1],1);
        }
        for (int i = m-2; i >=0 ; i--) {
            for(int j = n-2;j>=0;j--){
                dp[i][j]=Math.max(Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}
