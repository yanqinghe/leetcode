public class Solution34 {
    public static void main(String[] args) {
        Solution34 solution = new Solution34();
        int[] arr = {1};
        int target = 0;
        solution.searchRange(arr, target);
        System.out.print(solution.searchRange(arr, target)[0]);
        System.out.print(solution.searchRange(arr, target)[1]);

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length < 1) {
            return res;
        }
        int i = 0;
        int j = nums.length - 1;
        int mid = (i + j) >> 1;
        while (i <= j) {
            mid = (i + j) >> 1;
            if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int resulti = i;
        i = 0;
        j = nums.length - 1;
        mid = (i + j) >> 1;
        while (i <= j) {
            mid = (i + j) >> 1;
            if (target >= nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (resulti <= j) {
            res[0] = resulti;
            res[1] = j;
        }
        return res;
    }


}
