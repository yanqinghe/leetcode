
public class Solution122 {
    public int maxProfit(int[] prices) {
        int maxIndex = 0;
        int minIndex = 0;
        int res = 0;
        boolean state = false;
        int i = 0;
        for (; i < prices.length - 1; i++) {
            if (!state && prices[i] < prices[i + 1]) {
                minIndex = i;
                state = true;
            }
            if (state && prices[i] > prices[i + 1]) {
                maxIndex = i;
                res += prices[maxIndex] - prices[minIndex];
                state = false;
            }
        }
        if (state) {
            res += Math.max(0, prices[i] - prices[minIndex]);
        }
        return res;
    }
}
