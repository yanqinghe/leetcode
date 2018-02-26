public class NumArray {
    int[] nums;
    int[] bits;
    public NumArray(int[] nums) {
        if(nums==null||nums.length<1) return;
        int len = nums.length;
        this.nums= new int[len+1];
        this.bits = new int[len+1];
        for (int i = 0; i < nums.length; i++) {
            update(i,nums[i]);
        }
    }

    public void update(int i, int val) {
        int delta =val-nums[i+1];
        for (int j = i+1; j < nums.length; j+=(j&-j)) {
            bits[j]+=delta;
        }
        nums[i+1]=val;
    }

    int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }
    int getSum(int i) {
        int res = 0;
        for (int j = i; j > 0; j -= (j&-j)) {
            res += bits[j];
        }
        return res;
    }
}
