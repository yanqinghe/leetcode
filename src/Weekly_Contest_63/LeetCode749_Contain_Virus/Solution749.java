import java.util.*;

public class Solution749 {
    public static void main(String[] args) {
        Solution749 solution_4 = new Solution749();
        int[][] grid = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,0,0},{1,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,1,0,0,0},{0,0,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,1,0},{0,0,0,0,1,0,1,0,0,0},{0,0,0,0,0,0,0,0,0,0}};

        System.out.println(solution_4.containVirus(grid));
    }        int[][] grid = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,0,0},{1,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,1,0,0,0},{0,0,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,1,0},{0,0,0,0,1,0,1,0,0,0},{0,0,0,0,0,0,0,0,0,0}};


    /**
     * 行数
     */
    int m;
    /**
     * 列树
     */
    int n;

    int[][] mark;


    int[][] G;

    public int containVirus(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        G = grid;

        mark = new int[m][n];

        int ans = 0;
        while (canInfect()) {
            ans += findMax();
            mark = new int[m][n];
        }
        return ans;

    }

    private int findMax() {
        Map<Integer, Set<Integer>> cntMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mark[i][j] > 0) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (G[nx][ny] == 0) {
                            cntMap.computeIfAbsent(mark[i][j], z -> new HashSet<>()).add(nx * n + ny);
                        }
                    }
                }
            }
        }

        //获取影响正常细胞较多的病毒区域
        int res = 0;
        int num = 0;
        for (int key : cntMap.keySet()) {
            if (cntMap.get(key).size() > num) {
                num = cntMap.get(key).size();
                res = key;
            }
        }

        //计算将该区域围起来所需要的墙的数目
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mark[i][j] == res) {
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                        if (mark[nx][ny] != res && G[nx][ny] == 0) {
                            ans++;
                        }
                    }
                    G[i][j] = -1;
                }

            }
        }

        //进行感染
        for (int key : cntMap.keySet()) {
            if (key == res) {
                continue;
            }

            Set<Integer> theSet = cntMap.get(key);
            for (int z : theSet) {
                int x = z / n;
                int y = z % n;

                G[x][y] = 1;
            }
        }

        //返回墙的结果
        return ans;
    }


    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    private boolean canInfect() {
        boolean can = false;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果当前单元格已经染病切未访问，
                if (G[i][j] == 1 && mark[i][j] == 0) {
                    //区域标识符
                    cnt++;
                    Queue<Integer> Q = new LinkedList<>();
                    Set<Integer> inQ = new HashSet<>();
                    //i*n+j 是为了保存当前单元格的坐标
                    //将当前单元格添加到队列和Set中
                    Q.add(i * n + j);
                    inQ.add(i * n + j);

                    while (!Q.isEmpty()) {
                        int tp = Q.poll();
                        inQ.remove(tp);
                        mark[i][j] = cnt;

                        int x = tp / n;
                        int y = tp % n;
                        //对当前单元格的四周进行染病
                        for (int k = 0; k < dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            //如果发生越界，跳过
                            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            //如果未染病，将当前可染病标识符设置为true，下一次迭代
                            if (G[nx][ny] == 0) {
                                can = true;
                                continue;
                            }
                            //如果nx和ny单元格
                            if (G[nx][ny] != 1) continue;
                            //如果当前单元格某区域已遍历单元格,进入下一迭代
                            if (mark[nx][ny] == cnt) continue;
                            //将当前单元格区域标识符设置为当前区域
                            mark[nx][ny] = cnt;
                            //压缩区域坐标
                            int key = nx * n + ny;
                            //
                            if (!inQ.contains(key)) {
                                Q.add(key);
                                inQ.add(key);
                            }
                        }
                    }

                }
            }
        }

        return can;
    }
}
