package LeetCode35_Search_Insert_Position;

public class Solution35 {
    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        int[] arr = {1, 3, 5, 6};
        int target = 5;
        System.out.print(solution.searchInsert(arr, target));
    }

    public int searchInsert(int[] nums, int target) {
        int res = 0;
        if (nums == null || nums.length < 1) {
            return res;
        }
        int i = 0;
        int j = nums.length;
        int mid;
        while (i <= j) {
            mid = (i + j) >> 1;
            if (mid >= nums.length || mid < 0) {
                return mid;
            }
            if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
