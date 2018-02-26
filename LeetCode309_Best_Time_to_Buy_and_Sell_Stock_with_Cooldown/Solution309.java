public class Solution309 {
    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        solution309.maxProfit(new int[]{
                1,2,3,0,2
        });
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] buy = new int[len];//i天之前最后一个操作是买
        int[] sell = new int[len];//i天之前最后一个操作是卖
        int[] cooldown = new int[len];
        int profit = 0;
        buy[0] = Integer.MIN_VALUE;
        for (int i = 1; i < len ; i++) {
            buy[i]=Math.max(cooldown[i-1]-prices[i],buy[i-1]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            cooldown[i]=Math.max(sell[i-1],cooldown[i-1]);
        }
        return Math.max(sell[len-2],sell[len-1]);
    }

    public int maxProfit3(int[] prices) {
        int buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        return sell;
    }
}
