package Next_Permutation_31;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] arr= {1,2,3,4};
        solution.nextPermutation(arr);
    }
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<1){
            return;
        }
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]>=nums[i]){
                //如果当前小于等于前一个元素，也就是从后往前是升序排列
//                那么跳过当前元素
                continue;
            }else{
//                如果发现元素不为降序排列，那么寻找这个元素后面的元素第一个大于当前元素的值
                for(int j= nums.length-1;j>i-1;j--){
                    if(nums[j]>nums[i-1]){
//                    交换这两个值，并且把后面的元素进行从后往前的升序排列
                        nums =reverse(i-1,j,nums);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    /**
     * 交换数组内的两个元素的位置，并且对两index1后的元素进行升序排列
     * @param index1  数组的第一个元素的位置
     * @param index2  数组的第二个元素的位置
     * @param nums 数组
     */
    public int[] reverse(int index1,int index2,int[] nums){
        int temp = nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
            //因为从index1以后的数组开始之前是降序排序，只需要进行反序，然后将数组加入进来就可以了
            Arrays.sort(nums,index1+1,nums.length);
        return nums;
    }
}
