package Weekly_Contest_61;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[][] a = {{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}};
        solution4.cherryPickup(a);

    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        int[][][][] dp = new int[n][n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        dp[i][j][k][l] = -2;//定义dp的初始值，为了放置后续的重复计算。
                    }
                }
            }
        }
        dp[0][0][0][0] = grid[0][0];
        int ans = dfsDP(n - 1, n - 1, n - 1, n - 1, dp, grid);
        if (ans < 0){
            return 0;
        }
        else{
            return ans;
        }
    }

    int dfsDP(int x0, int y0, int x1, int y1, int[][][][] dp, int[][] grid) {
        int n = grid.length;
        if (!(x0 >= 0 && x0 < n && y0 >= 0 && y0 < n && x1 >= 0 && x1 < n && y1 >= 0 && y1 < n)) {
            return -1;
        }
        //不能通过，返回-1
        if (grid[x0][y0] < 0 || grid[x1][y1] < 0)
            return -1;
        //当前位置已经计算过，直接返回
        if (dp[x0][y0][x1][y1] != -2)
            return dp[x0][y0][x1][y1];
        //
        dp[x0][y0][x1][y1] = -1;
        int sum = 0;
        //如果两个坐标定位在同一点，该点的草莓只能摘取一次
        if (x0 == x1 && y0 == y1) {
            sum += grid[x0][y0];
        } else {
            //计算过两条路径的和
            sum += grid[x0][y0] + grid[x1][y1];
        }
        //分别计算剩下的四个位置
        int t = dfsDP(x0 - 1, y0, x1 - 1, y1, dp, grid);
        if (t >= 0)
            dp[x0][y0][x1][y1] = Math.max(dp[x0][y0][x1][y1], t + sum);

        t = dfsDP(x0 - 1, y0, x1, y1 - 1, dp, grid);
        if (t >= 0)
            dp[x0][y0][x1][y1] = Math.max(dp[x0][y0][x1][y1], t + sum);

        t = dfsDP(x0, y0 - 1, x1 - 1, y1, dp, grid);
        if (t >= 0)
            dp[x0][y0][x1][y1] = Math.max(dp[x0][y0][x1][y1], t + sum);

        t = dfsDP(x0, y0 - 1, x1, y1 - 1, dp, grid);
        if (t >= 0)
            dp[x0][y0][x1][y1] = Math.max(dp[x0][y0][x1][y1], t + sum);
        //取最大值并返回
        return dp[x0][y0][x1][y1];

    }
}
