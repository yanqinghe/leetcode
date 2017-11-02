package LeetCode74_Search_a_2D_Matrix;

import LeetCode7_Reverse_Integer.Solution7;

public class Solution74 {
    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        int[][] s = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int[][] s2 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println("args = [" + solution74.searchMatrix(s, 30) + "]");
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (target > matrix[m - 1][n - 1] || target < matrix[0][0]) {
            return false;
        }
        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVa = matrix[mid][n - 1];
            if (midVa == target) {
                return true;
            } else if (target < matrix[left][n - 1]) {
                //如果在left数组内,进入下一步收缩
                right = left;
                break;
            } else if (target < midVa) {
                right = mid - 1;
            } else if (target > midVa) {
                left = mid + 1;
            }
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int midVa = matrix[left][mid];
            if (target == midVa) {
                return true;
            } else if (target < midVa) {
                r = mid - 1;
            } else if (target > midVa) {
                l = mid + 1;
            }
        }
        return false;
    }
}

