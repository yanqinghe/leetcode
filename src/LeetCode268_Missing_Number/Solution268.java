import java.awt.event.TextEvent;

public class Solution268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res  =0;
        for (int i = 0; i <n ; i++) {
            res^=nums[i];
            res^=i+1;
        }
        return res;
    }
}
