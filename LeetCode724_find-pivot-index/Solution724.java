import java.lang.reflect.Array;

public class Solution724 {
    public static void main(String[] args) {
        Solution724 solution724 = new Solution724();
        System.out.println(solution724.pivotIndex(new int[]{
                1,7,3,6,5,6
        }));
    }
    public int pivotIndex(int[] nums) {
        int sum =0;
        for (int num : nums) {
            sum+=num;
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(((sum-nums[i])&1)!=1&&cnt==(sum-nums[i])/2) {
                return i;
            }
            cnt+=nums[i];
        }
        return -1;
    }
}
