package LeetCode46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        help(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public void help(List<Integer> temp, int[] nums, boolean[] dp) {
        if (temp.size() == nums.length) {
            List<Integer> a = new ArrayList<>(temp);
            result.add(a);
        } else {
            for (int i = 0; i < nums.length; i++) {
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
