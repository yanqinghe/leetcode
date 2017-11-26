package LeetCode123_Best_Time_to_Buy_and_Sell_Stock_3;

public class  Solution123 {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int[] dpG = new int[3];
        int[] dpL = new int[3];
        for (int i = 0; i < prices.length - 1; i++) {
            int delta = prices[i + 1] - prices[i];
            for (int j = 2; j >= 1; j--) {
                dpL[j] = Math.max(dpG[j - 1] + (delta < 0 ? 0 : delta), dpL[j] + delta);
                dpG[j] = Math.max(dpL[j], dpG[j]);
            }
        }
        return dpG[2];
    }
}
