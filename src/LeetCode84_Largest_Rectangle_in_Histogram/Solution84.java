import java.util.Stack;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) {
            return 0;
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() != 1 && heights[stack.peek()] >= heights[i]) {
                result = Math.max(heights[stack.pop()] * (i - stack.peek() - 1), result);
            }
            stack.add(i);
        }
        int right = stack.peek();
        while (stack.size() > 1) {
            result = Math.max(heights[stack.pop()] * (right - (stack.peek())), result);
        }
        return result;

    }
}