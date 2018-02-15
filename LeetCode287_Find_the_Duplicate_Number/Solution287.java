import java.util.Arrays;

public class Solution287 {
    public int findDuplicate(int[] nums) {
        if(nums==null||nums.length<1) return 0;

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1])
                return nums[i];
        }
        return  nums[0];
//            int i =1;
//            while (i<nums.length){
//                int n = nums[i];
//                if(i==n){
//                    i++;
//                    continue;
//                }
//                if(nums[n]>0){
//                    nums[i]=nums[n];
//                    nums[n]=n;
//                }else {
//                    return n;
//                }
//            }
//            return nums[nums.length-1];
    }

    public int findDuplicate1(int[] nums) {
        if(nums==null||nums.length<1) return 0;

            int i =0;
            while (i<nums.length){
                int n = nums[i];
                //如果当前位置正确
                if(i==n){
                    i++;
                    continue;
                }
                //如果当前位置不合适
                if(nums[n]>0){
                    //交换两个数字
                    nums[i]=nums[n];
                    nums[n]=-n;
                }else {
                    return n;
                }
            }
            return nums[nums.length-1];
    }
}
