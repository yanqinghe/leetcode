
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1 || triangle.get(0).size() < 1) {
            return 0;
        }
        int length = triangle.size();
        int[] dp = new int[triangle.get(length - 1).size()];
        for (int i = 0; i < length; i++) {
            int from = triangle.get(i).size() - 1;
            for (int j = from; j >= 0; j--) {
                if (j == 0) dp[0] = dp[0] + triangle.get(i).get(0);
                else if (j == from) dp[j] = dp[j - 1] + triangle.get(i).get(j);
                else dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
        }
        int min = dp[0];
        for (int i : dp) {
            if (i < min) min = i;
        }
        return min;
    }
}
