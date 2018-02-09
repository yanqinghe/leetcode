
import java.util.*;

public class Solution220 {
    public static void main(String[] args) {
        Solution220 solution220 = new Solution220();
        solution220.containsNearbyAlmostDuplicate(new int[]{-2147483647,2147483647},1,2147483647);
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) return false;

        for (int i=0, j=1; i<nums.length-1 && j<nums.length;)
        {
            if (Math.abs((long) nums[i] - nums[j]) <= t) return true;

            if (j-i == k || j == nums.length-1)
            {
                i++;
                if (t != 0)
                    j = i + 1;
            }
            else
                j++;
        }
        return false;
    }
}
