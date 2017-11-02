package LeetCode695_Max_Area_of_Island;

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
        System.out.println(solution695.maxAreaOfIsland(d));
    }

    class Help {
        Area area = new Area();

        public Help(int area) {
            this.area.area = area;
        }

        class Area {
            int area = 0;

            public Area() {
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        Help sea = new Help(0);
        Help[] dp = new Help[grid[0].length];
        int max = 0;
        dp[0] = new Help(grid[0][0]);
        max = dp[0].area.area;

        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i] == 0) {
                dp[i] = sea;
            } else if (grid[0][i] == grid[0][i - 1]) {
                dp[i - 1].area.area += 1;
                dp[i] = dp[i - 1];
            } else {
                dp[i] = new Help(1);
            }
            if (dp[i].area.area > max) {
                max = dp[i].area.area;
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dp[j] = sea;
                } else {
                    if (j == 0) {
                        if (grid[i - 1][j] == 0) {
                            dp[j] = new Help(grid[i][j]);
                        } else {
                            dp[j].area.area++;
                        }
                    } else {
                        if (grid[i][j] == 0) {
                            dp[j] = sea;
                        } else {
                            if (grid[i - 1][j] == 0) {
                                if (grid[i][j - 1] == 0) {
                                    dp[j] = new Help(1);
                                } else {
                                    dp[j - 1].area.area++;
                                    dp[j] = dp[j - 1];
                                }
                            } else {
                                if (grid[i][j - 1] == 0) {
                                    dp[j].area.area++;
                                } else {
                                    if (dp[j - 1].area == dp[j].area) {
                                        dp[j].area.area++;
                                    } else {
                                        dp[j].area.area += dp[j - 1].area.area + 1;
                                        dp[j - 1].area = dp[j].area;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < dp.length; j++) {
                if (dp[j].area.area > max) {
                    max = dp[j].area.area;
                }
            }
        }


        return max;

    }
}
