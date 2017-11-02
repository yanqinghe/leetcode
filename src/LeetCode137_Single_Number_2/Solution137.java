package LeetCode137_Single_Number_2;

public class Solution137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum =0;
            for (int n: nums
                 ) {
                sum+=(n>>i)&1;
            }
            res|=(sum%3)<<i;
        }
        return res;
    }
}
