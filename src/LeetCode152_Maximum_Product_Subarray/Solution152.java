
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution152 {
    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int [] a = {-3,0,1,-2};
        System.out.println("args = [" + solution152.maxProduct(a) + "]");;
    }
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int prevMin = nums[0], prevMax = nums[0];
        int curMin, curMax;
        for (int i = 1; i < nums.length; ++i) {
            curMin = Math.min(Math.min(prevMax * nums[i], prevMin * nums[i]), nums[i]);
            curMax = Math.max(Math.max(prevMax * nums[i], prevMin * nums[i]), nums[i]);
            prevMin = curMin;
            prevMax = curMax;
            max = Math.max(curMax, max);
        }
        return max;
    }

}
