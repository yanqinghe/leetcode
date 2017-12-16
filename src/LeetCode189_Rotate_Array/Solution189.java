public class Solution189 {
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length<1||k==0||k>=nums.length) return;
        k %= nums.length;//k值超过数组长度时
        reverse(nums,  0, nums.length-1);//翻转整个数组
        reverse(nums, 0, k-1);//翻转前k个数
        reverse(nums, k, nums.length-1);//翻转剩下的数
    }
    void reverse(int[] nums,int i,int j){
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
