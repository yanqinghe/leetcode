
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length<1||k<1) return 0;
        if(k>=prices.length) return maxProfit2(prices);
        int [] dpG = new int[k+1];
        int [] dpL = new int[k+1];
        for (int i = 0; i < prices.length-1; i++) {
            int delta = prices[i + 1] - prices[i];
            for (int j = k; j >=1 ; j--) {
                dpL[j] = Math.max(dpG[j - 1] + (delta < 0 ? 0 : delta), dpL[j] + delta);
                dpG[j] = Math.max(dpL[j], dpG[j]);
            }
        }
        return  dpG[k];
    }
    int maxProfit2(int[] prices){
        int res = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

}
