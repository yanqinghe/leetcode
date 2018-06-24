import java.util.Arrays;

public class Solution670 {
    public static void main(String[] args) {
        Solution670 solution670 = new Solution670();
        System.out.println(solution670.maximumSwap(9973));
    }
    public int maximumSwap(int num) {
        char[] chars = (num+"").toCharArray();
        char[] nums = new char[chars.length];
        int[] index = new int[chars.length];
        char max = (char)0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(chars[i]>max){
                nums[i]=chars[i];
                index[i]=i;
                max=nums[i];
            }else {
                nums[i]=max;
                index[i]=index[i+1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=chars[i]){
               char temp = chars[i];
               chars[i]=nums[i];
               chars[index[i]]=temp;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
