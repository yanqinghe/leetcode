import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int max =nums[nums.length-1];
        int d = max-nums[0];
        int ret = 0;
        for (int num : nums) {
            ret+=d-(max-num);
        }
        return ret;
    }
}
