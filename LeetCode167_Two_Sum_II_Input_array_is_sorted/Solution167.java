package LeetCode167_Two_Sum_II_Input_array_is_sorted;
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        int[] res = new int[2];
        while (left<right){
            int sum = numbers[left]+numbers[right];
            if(sum>target){
                //如果两者的和大于目标值，说明需要移动右边的游标
                right--;
            }else if(sum<target){
                //如果两者的值小于目标值，说明需要移动左边的游标
                left++;
            }else {
                res[0]=left+1;
                res[1]=right+1;
                break;
            }
        }
        return res;
    }
}
