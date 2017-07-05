package Two_Sum_1;

/**
 * Created by yanqinghe on 2017/7/2.
 */
public class Solution {
    public static void main(String[] args){

    }
    public int[] twoSum(int[] nums, int target) {
        int[] answer= new int[2];
        for(int i=0;i<nums.length;i++){
            answer[0]=nums[i];
            int temp = target-answer[0];
            for(int j=i;j<nums.length;j++){
                if(nums[j]==temp){
                    return answer;
                }
            }
        }
        return answer;
    }

}
