import java.util.HashSet;
import java.util.Set;

public class Solution695 {
    public static void main(String[] args) {
        Solution695 solution695 = new Solution695();
        int[][] a = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] b = {{0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}};

        int[][] c = {{0, 1},
                {1, 1}, {1, 1}};
        int[][] d = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        System.out.println(solution695.maxAreaOfIsland(a));
    }



    int m =0;
    int n =0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private int dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i>=m||j>=n||grid[i][j]==0) return 0 ;
        grid[i][j]=0;
        int sum =1;
        for (int k = 0; k < 4; k++) {
            sum+=dfs(grid,i+dir[k][0],j+dir[k][1]);
        }
        return sum;
    }

}
