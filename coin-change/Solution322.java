import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution322 {
    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();

        System.out.println( solution322.coinChange(new int[]{2},3));
    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0)  return 0;
        if(coins==null||coins.length==0) return -1;
        Arrays.sort(coins);
        int len = amount+coins[coins.length-1]+1;
        int[] dp = new int[len];
        dp[0]=0;
        for (int i = 1; i < len; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
            }
        }
        return 0;
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
