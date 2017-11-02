package LeetCode81_Search_in_Rotated_Sorted_Array_2;

class Solution81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return false;
        //初始化左右游标 
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                //找到目标值返回true
                return true;
            }
            if (nums[mid] > nums[left]) {
                //mid和left在同一支
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                //mid和right在同一支
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}
