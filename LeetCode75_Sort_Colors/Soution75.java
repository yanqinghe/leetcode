public class Soution75 {
    public void sortColors(int[] nums) {
        int rn = 0, bn = 0;//初始化红蓝的计数
        //上限是nums.length-bn 因为后面的bn个是已经归类好的蓝色球，所以不需要进行操作
        //如果继续进行操作会把归类好的打乱
        for (int i = 0; i < nums.length - bn; i++) {
            if (nums[i] == 0) {
                //如果是红色
                swap(nums, i, rn);
                rn++;
            } else if (nums[i] == 2) {
                swap(nums, i, nums.length - 1 - bn);
                bn++;
                i--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

