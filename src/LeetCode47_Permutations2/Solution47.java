package LeetCode47_Permutations2;

import java.util.*;

public class Solution47 {
    public static void main(String[] args) {

    }

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //关键的一句，首先要对数组进行排序，让重复的元素排列在一起
        Arrays.sort(nums);
        help(new ArrayList<>(), nums, new boolean[nums.length]);

        return new ArrayList<>(resultList);
    }

    public void help(List<Integer> temp, int[] nums, boolean[] dp) {
        if (temp.size() == nums.length) {
            List<Integer> a = new ArrayList<>(temp);
            resultList.add(a);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && !dp[i - 1] && nums[i] == nums[i - 1]) {
                    //从第二个元素开始，如果该元素为重复元素，那么，跳过该元素的递归
                    continue;
                }
                if (!dp[i]) {
                    temp.add(nums[i]);
                    dp[i] = true;
                    help(temp, nums, dp);
                    temp.remove(temp.size() - 1);
                    dp[i] = false;
                }
            }
        }
    }
}
