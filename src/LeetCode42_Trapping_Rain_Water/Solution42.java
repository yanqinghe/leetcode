package LeetCode42_Trapping_Rain_Water;

import java.util.Stack;

class Solution42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] a = {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3};
        System.out.println(solution42.trap(a));
    }

    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack2 = new Stack();
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[i] < stack.peek()) {
                stack.add(height[i]);
                stack2.add(i);
            } else {
                int preH = 0;
                int r = 0;
                while (!stack.isEmpty() && height[i] >= stack.peek()) {
                    int h = stack.pop();
                    r += (h - preH) * (i - stack2.pop() - 1);
                    preH = h;
                }
                if (!stack.isEmpty() && height[i] > preH) {
                    r += (height[i] - preH) * (i - stack2.peek() - 1);
                }
                stack.add(height[i]);
                stack2.add(i);
                result += r;
            }
        }
        return result;
    }
}