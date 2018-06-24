import java.util.*;

public class Solution847 {

    public static void main(String[] args) {
        Solution847 solution847  = new Solution847();
        System.out.println(solution847.shortestPathLength(new int[][]{
                {1,2,3},{0},{0},{0}
        }));
    }
    public int shortestPathLength(int[][] graph) {
        int N= graph.length;
        long[][] dp = new long[N][1<<N];
        Queue<State> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.add(new State(i,1<<i));
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][1<<i]=0;
        }

        while (!queue.isEmpty()){
            State state  = queue.poll();
            for (int i : graph[state.cur]) {
                int newSate = state.state | 1<<i;
                if(dp[i][newSate]>dp[state.cur][state.state]+1){
                    dp[i][newSate]=dp[state.cur][state.state]+1;
                    queue.add(new State(i,newSate));
                }
            }
        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            min = Math.min(min,dp[i][(1<<N)-1]);
            
        }
        return (int) min;
    }
    class State{
        int cur;
        int state;

        public State(int cur, int state) {
            this.cur = cur;
            this.state = state;
        }
    }
}
