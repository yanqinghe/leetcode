import java.util.*;

public class Solution749My {


    public static void main(String[] args) {
        Solution749My solution749My = new Solution749My();
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        solution749My.containVirus(grid);
    }

    int[][] GGrid;
    int[][] areaMarked;
    Set<Integer>[] areaEffect;
    int m, n;
    int areaNum=0;
    public int containVirus(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        GGrid = grid;
        areaMarked = new int[m][n];

        int ans = 0;
        while (isGoOnAndFindArea()) {
            ans += findMaxEffecArea();
            areaMarked = new int[m][n];
        }
        return ans;
    }

    int findMaxEffecArea() {
        //首先获取影响力最大的区域
        areaEffect = new HashSet[areaNum+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (areaMarked[i][j] > 0) {
                    for (int[] dir: dirs
                         ) {
                        int dx = i+dir[0];
                        int dy = j+dir[1];
                        if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                        if (0==GGrid[dx][dy]) {
                            if(areaEffect[areaMarked[i][j]]==null){
                                areaEffect[areaMarked[i][j]]=new HashSet<>();
                            }
                            areaEffect[areaMarked[i][j]].add(dx*n+dy);
                        }
                    }
                }
            }
        }
        int areaNum = 0;
        int effectNum = 0;
        for (int i = 0; i < areaEffect.length; i++) {
            if (areaEffect[i] != null && areaEffect[i].size() > effectNum) {
                areaNum = i;
                effectNum = areaEffect[i].size();
            }
        }

        //对影响力最大的区域建墙
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (areaMarked[i][j] == areaNum) {
                    for (int[] dir : dirs
                            ) {
                        int dx = i + dir[0];
                        int dy = j + dir[1];
                        if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                        if (areaMarked[dx][dy] != areaNum && GGrid[dx][dy] == 0) {
                            ans++;
                        }
                    }
                    //无法感染
                    GGrid[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < areaEffect.length; i++) {
            if (i!=areaNum&&areaEffect[i] != null ) {
                for (int z : areaEffect[i]) {
                    GGrid[z / n][z % n] = 1;
                }
            }
        }

        return ans;

    }

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    boolean isGoOnAndFindArea() {
        boolean is = false;
        int m = GGrid.length;
        int n = GGrid[0].length;
        areaNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (GGrid[i][j] == 1 && areaMarked[i][j] == 0) {
                    areaNum++;
                    //如果当前单元格包含病毒切且为属于某一个区域
                    Queue<Integer> queue = new LinkedList<>();
                    Set<Integer> inQ = new HashSet<>();
                    queue.offer(i * n + j);
                    inQ.add(i * n + j);
                    while (!queue.isEmpty()) {
                        int cell = queue.poll();
                        int cellx = cell / n;
                        int celly = cell % n;
                        areaMarked[cellx][celly] = areaNum;
                        inQ.remove(cell);
                        //对当前单元格个的四个方向进行遍历
                        for (int[] dir : dirs
                                ) {
                            //计算当前方向单元格的坐标
                            int dx = cellx + dir[0];
                            int dy = celly + dir[1];
                            int d = dx * n + dy;
                            if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                            if (GGrid[dx][dy] == 0) {
                                //如果当前单元格是健康的单元格，说明可以继续感染
                                //如果当前单元格没有被当前的y区域所记录，那么就添加到区域影响力内
                                is = true;
                                //更新当前未感染点的所受影响区域的编号
                                continue;
                            }
                            if (GGrid[dx][dy] != 1) {
                                //说明当前但当前单元格已经被围墙所围起来，无法进行感染
                                continue;
                            }
                            if (areaMarked[dx][dy] == areaNum) {
                                //说明当前单元格是区域
                                continue;
                            }
                            areaMarked[dx][dy] = areaNum;
                            //以上情况都不满足，说明当前单元格属于当前已感染区域。
                            if (!inQ.contains(cell)) {
                                //如果当前单元格没有在队列内，添加到队列内
                                queue.offer(d);
                                inQ.add(d);
                            }
                        }
                    }
                }
            }
        }
        //返回当前状态是否可感染
        return is;
    }
}
