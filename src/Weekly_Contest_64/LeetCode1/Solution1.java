/**
 * Created with Hehel
 * Description:
 * User: Hehel
 * Date: 2017-12-24
 * Time: 10:27
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1);
    }
    public int dominantIndex(int[] nums) {
        int max =0;
        int max2 = -1;
        int index =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                if(nums[i]>=max*2){
                    max2=max;
                }else {
                    max2=-1;
                }
                max=nums[i];
                index=i;
            }else if(nums[i]*2>max) max2=-1;
        }
        if(max2==-1) return -1;
        else return index;
    }
}
