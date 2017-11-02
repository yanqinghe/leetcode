package LeetCode136_Single_Number;

import java.lang.reflect.Array;

public class Solution136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums
                ) {
            result ^= n;
        }
        return result;
    }
}
