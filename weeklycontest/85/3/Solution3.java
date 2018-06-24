public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.new21Game2(21,17,10));
    }
    public double new21Game2(int N, int K, int W) {
        double[] dp = new double[N+3];
        dp[0] = 1;
        dp[1] = -1;
        double val = 0;
        for(int i = 0;i < K;i++){
            val += dp[i];
            if(i+1 <= N)dp[i+1] += val / W;
            if(i+W+1 <= N)dp[i+W+1] -= val / W;
        }
        double ret = 0;
        for(int i = K;i <= N;i++){
            val += dp[i];
            ret += val;
        }
        return ret;
    }
    public double new21Game(int N, int K, int W) {
        double[] pArr = new double[N+W+1];
        pArr[0]=1;
        double pC =pArr[0];

//            dfs(0,1.0,W,pArr,K);

        double rt = 0;
        for (int i = 0; i < pArr.length; i++) {
            if(i<=N) rt+=pArr[i];
        }
        double sum =0;
        for (int i = 0; i <pArr.length ; i++) {
            sum+=pArr[i];
        }
        return rt;
    }
    void dfs(int cur,double p,int W,double[]pArr,int K){
        if(cur>=K) {
            pArr[cur]+=p;
            return;
        }
        int next;
        for (int i = 1; i <= W; i++) {
            next = cur+i;
            dfs(next,p*(1.0/W),W,pArr,K);
        }
    }
}
