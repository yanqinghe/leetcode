public class Solution807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        int[] tDP = new int[n];
        int[] lDP = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lDP[i]=Math.max(grid[i][j],lDP[i]);
                tDP[j]=Math.max(grid[i][j],tDP[j]);
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt +=Math.min(lDP[i],tDP[j])- grid[i][j];
            }
        }
        return cnt;
    }
}
