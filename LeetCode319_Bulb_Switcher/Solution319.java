public class Solution319 {
    public static void main(String[] args) {
        Solution319 solution319  = new Solution319();
        for (int i = 0; i < 1000; i++) {
            System.out.print(i+":");
            System.out.println(solution319.bulbSwitch(i)+":"+solution319.bulbSwitch2(i));
        }
    }
    public int bulbSwitch(int n) {
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(dp,i);
        }

        int cnt =0;
        for (boolean b : dp) {
            if(b) cnt++;
        }
        return cnt;
    }
    void  dfs(boolean[]dp,int l){
        for (int i = l; i <dp.length ; i+=l+1) {
            dp[i]=!dp[i];
        }
    }

    /**
     * 通过上述复杂代码的统计，可以发现规律，
     * @param n
     * @return
     */
    public int bulbSwitch2(int n) {
        return (int)Math.sqrt(n);
    }
}
