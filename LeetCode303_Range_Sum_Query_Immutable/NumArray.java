/**
 * 最简单的实现
 */
class NumArray {
    int [] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int sum =0;
        for(int index =i;index<=j;index++){
            sum+=this.nums[index];
        }
        return sum;
    }
}
class NumArray1 {
    int [] nums;
    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        if(nums.length<1) return;
        this.nums[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            this.nums[i]=this.nums[i-1]+nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return this.nums[j];
        else return this.nums[j]-this.nums[i-1];
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */