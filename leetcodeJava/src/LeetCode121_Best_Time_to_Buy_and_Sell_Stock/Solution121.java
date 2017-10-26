package LeetCode121_Best_Time_to_Buy_and_Sell_Stock;

import java.util.Arrays;

public class Solution121 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<1){
            return 0;
        }
        int minIndex = 0;
        int maxIndex = 0;
        int res  = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<prices[minIndex]){
                res=Math.max(prices[maxIndex]-prices[minIndex],res);
                minIndex=i;
                maxIndex=i;
            }
            if(prices[i]>=prices[maxIndex]){
                maxIndex=i;
            }
        }
        return Math.max(prices[maxIndex]-prices[minIndex],res);
    }
}
