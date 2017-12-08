package LeetCode200_Number_of_Islands;

public class Solution200 {
    int res =0;
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length<1||grid[0].length<1) return 0;
        int m =grid.length,n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(!dp[i][j]&&grid[i][j]=='1'){
                    help(grid,dp,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    void help(char[][] grid,boolean[][] dp,int i,int j){
        if(dp[i][j]) return;
        if(grid[i][j]=='1'){
            dp[i][j]=true;
            if(i>0) help(grid,dp,i-1,j);
            if(j>0) help(grid,dp,i,j-1);
            if(i<grid.length-1) help(grid,dp,i+1,j);
            if(j<grid[0].length-1) help(grid,dp,i,j+1);
        }
    }
}
