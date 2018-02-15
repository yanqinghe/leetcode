import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Solution300 {
    /**
     * 时间为o(n^2)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    cnt = Math.max(cnt, dp[j]);
                }
            }
            dp[i] = ++cnt;
            max = Math.max(cnt, max);
        }
        return max;
    }

    /**
     * 题目建议时间复杂度可以优化到O(nlogn)，网上看到的答案如下
     * 
     * 维护一个单调递增子序列，它的关键原理在于，
     * 如果当前值小于单调递增子序列中的某个元素，则替换之，因为单调递增子序列能否增长，值取决于最后一个元素，替换内部的元素并不影响。
     * 
     */

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            //inarySearch()方法的返回值为：
            //1、如果找到关键字，则返回值为关键字在数组中的位置索引，且索引从0开始
            //2、如果没有找到关键字，返回值为负的插入点值，所谓插入点值就是第一个比关键字大的元素在数组中的位置索引，而且这个位置索引从1开始。
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}