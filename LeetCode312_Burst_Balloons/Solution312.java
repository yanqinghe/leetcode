import java.util.LinkedList;

public class Solution312 {
    public static void main(String[] args) {
        Solution312 solution312 = new Solution312();
        System.out.println(solution312.maxCoins(new int[]{
                7, 9, 8, 0, 7, 1, 3, 5
        }));
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int len = nums.length;
        /*
         dp数组保存的是dp[i][j]代表的从i开始到j区间内的数字序列所能得到的最高分
         所以dp对应的递推公式为dp[i][j] = max(dp[i][j], nums[i - 1]*nums[k]*nums[j + 1] + dp[i][k - 1] + dp[k + 1][j])   )
         */
        int[][] dp = new int[len + 2][len + 2];

        int[] nums2 = new int[len + 2];
        nums2[0] = nums2[len + 1] = 1;
        for (int i = 1; i < len + 1; i++) {
            nums2[i] = nums[i - 1];
        }
        for (int l = 1; l <= len; l++) {
            for (int left = 1; left <= len - l + 1; left++) {
                int right = left + l - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] =
                            Math.max(dp[left][right], nums2[left - 1] * nums2[k] * nums2[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }
        return dp[1][len];
    }

}
