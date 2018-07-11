public class Solution463 {
    public static void main(String[] args) {
        Solution463 solution463 = new Solution463();
        System.out.println(solution463.islandPerimeter(new int[][]{
                {1,1},
                {1,1}
        }));
    }
    int m =0;
    int n =0;

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    int cnt =0;
                    for (int k = 0; k < 4; k++) {
                        int i1 = i+dir[k][0];
                        int j1 = j+dir[k][1];
                        if(!(i1>=0&&j1>=0&&i1<m&&j1<n && grid[i1][j1]==1)){
                            cnt++;
                        }
                    }
                    max+=cnt;
                }
            }
        }
        return max;
    }
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private int dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i>=m||j>=n||grid[i][j]==0) return 0 ;
        if(grid[i][j]<0) return -1;
        grid[i][j]=-1;
        int sum =0;
        for (int k = 0; k < 4; k++) {
            int ret = dfs(grid,i+dir[k][0],j+dir[k][1]);
            if(ret==0) {
                sum++;
            }else if(ret>0){
                sum+=ret;
            }
        }
        return sum;
    }
}
