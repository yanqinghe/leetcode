package LeetCode73_Set_Matrix_Zeroes;

public class Solution73 {
    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int[][] s = {{1, 2, 3, 0},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}};
        solution73.setZeroes(s);
        return;
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }
        boolean firstRowZero = false;//状态
        boolean firstColZero = false;//状态
        int m = matrix.length;
        int n = matrix[0].length;
        for (int temp : matrix[0]
                ) {
            if (temp == 0) {
                firstRowZero = true;
            }
        }
        for (int[] temp : matrix
                ) {
            if (temp[0] == 0) {
                firstColZero = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = m - 1; i > 0; i--) {
            for (int j = n - 1; j > 0; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            firstColZero = firstRowZero = true;
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}

