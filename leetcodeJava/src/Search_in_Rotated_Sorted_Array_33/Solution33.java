package Search_in_Rotated_Sorted_Array_33;

public class Solution33 {
    public static void main(String[] args) {
        Solution33 solution = new Solution33();
        int[] arr = {1, 3};

        System.out.println(solution.search(arr, 0));
    }

    public int search(int[] nums, int target) {
        if (nums.length < 1 || nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        return binarySearch(0, nums.length - 1, nums, target);
    }

    //    二分法递归
    public int binarySearch(int i, int j, int[] nums, int target) {
        if (i > j) {
            return -1;
        }
        if (nums[i] == target) {
            return i;
        }
        if (nums[j] == target) {
            return j;
        }
        int mid = (j + i) / 2;
        if (nums[mid] == target) {
            return mid;
        }
//        第一种情况，也就是数组完全顺序排列
        if (nums[i] < nums[j]) {
            if (target < nums[i] || target > nums[j]) {
                return -1;
            }
            if (target < nums[mid]) {
                return binarySearch(i + 1, mid - 1, nums, target);
            } else {
                return binarySearch(mid + 1, j - 1, nums, target);
            }

        } else if (nums[mid] > nums[i]) {
            if (target > nums[i] && target < nums[mid]) {
                return binarySearch(i + 1, mid - 1, nums, target);
            } else {

                return binarySearch(mid + 1, j - 1, nums, target);
            }
        } else {
            if (target > nums[mid] && target < nums[j]) {

                return binarySearch(mid + 1, j - 1, nums, target);
            } else {
                return binarySearch(i + 1, mid - 1, nums, target);
            }
        }
    }
}
