
public class Solution64 {
    public static void main(String[] args) {
        Solution64 solution64 = new Solution64();
        int[][] a = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        solution64.minPathSum(a);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;

        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] += grid[i][0];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[n - 1];
    }
}
