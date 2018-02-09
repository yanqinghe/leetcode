public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        calin(nums,0,nums.length-1,1);
        return nums;
    }
    int calin(int[] nums,int left,int right,int outsides){
        if(left<right){
            int leftN = nums[left],rightN = nums[right];
            int insides = calin(nums,left+1,right-1,outsides*leftN*rightN);
            nums[left]=insides*rightN;
            nums[right]=insides*leftN;
            return left*right*insides;
        }else if(left==right){
            nums[left]=outsides;
            return nums[left];
        }else {
            return 1;
        }
    }
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
