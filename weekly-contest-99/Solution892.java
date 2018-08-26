public class Solution892 {
    public static void main(String[] args) {
        Solution892 solution892 = new Solution892();
        solution892.surfaceArea(new int[][]{
                {1,0},{0,2}
        });
    }
    public int surfaceArea(int[][] grid) {
        int N =grid.length;
        int [][] dp = new int[N][N];
        int ret = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(grid[i][j]>0){
                    dp[i][j]=cal(grid,i,j,N);
                    ret+=dp[i][j];
                }

            }
        }
        return ret;
    }
    private static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private int cal(int[][] grid,int i,int j,int N){
        int x =0,y=0;
        int ret = 0;
        for (int k = 0; k < 4; k++) {
            x=i+dir[k][0];
            y=j+dir[k][1];
            if(x<N&&x>-1&&y<N&&y>-1){
                ret+=Math.max(0,grid[i][j]-grid[x][y]);
            }else {
                ret+=grid[i][j];
            }
        }
        return ret+2;
    }
}
