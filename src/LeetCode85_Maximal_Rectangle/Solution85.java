package LeetCode85_Maximal_Rectangle;

import java.util.Stack;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != '0') {
                    matrix[i][j] = (char) (matrix[i][j] + matrix[i - 1][j] - '0');
                }

            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, largestRectangleArea(matrix[i]));
        }
        return max;

    }

    public int largestRectangleArea(char[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() != 1 && heights[stack.peek()] >= heights[i]) {
                result = Math.max((heights[stack.pop()] - '0') * (i - stack.peek() - 1), result);
            }
            stack.add(i);
        }
        int right = stack.peek();
        while (stack.size() > 1) {
            result = Math.max((heights[stack.pop()] - '0') * (right - (stack.peek())), result);
        }
        return result;

    }
}
