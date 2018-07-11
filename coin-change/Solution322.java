import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution322 {
    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();

        System.out.println( solution322.coinChange(new int[]{2147483647},2));
    }

    public int coinChange(int[] coins, int amount) {
        //如果硬币集合为空或者长度为0，那么直接返回
        if(coins==null||coins.length==0) return -1;
        //动态规划数组的长度
        int len = amount+1;
        int[] dp = new int[len];
        //初始化
        Arrays.fill(dp,-1);
        dp[0]=0;
        for (int coin : coins) {
            if(coin<len) dp[coin]=1;
        }
        for (int target = 1; target < len; target++) {
            for (int coin : coins) {
                int j = target-coin;
                if(j>=0&&dp[j]!=-1){
                    dp[target]=dp[target]==-1?dp[j]+1:Math.min(dp[target],dp[j]+1);
                }
            }
        }
        return dp[amount];
    }
        /**
         * 该算法时间超时
         * @param coins
         * @param amount
         * @return
         */
    public int coinChange2(int[] coins, int amount) {
        //特殊情况，目标为0元，直接返回
        if(amount==0) return 0;
        //对硬币数组进行排序
//        Arrays.sort(coins);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{amount,0});
        int ret = -1;
        //迭代的终止条件是找到合适的解或者遍历完后无合适解
        while (ret<0&&!queue.isEmpty()){
            int[] first = queue.poll();
            int cnt = first[1]+1;
            for (int coin : coins) {
                if(coin>first[0])
                    continue;
                if(coin==first[0]){
                    ret=cnt;
                }else{
                    queue.offer(new int[]{first[0]-coin,cnt});
                }
            }
        }
        return ret;
    }
}
