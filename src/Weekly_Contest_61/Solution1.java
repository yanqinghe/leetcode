package Weekly_Contest_61;

import java.util.Stack;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int [] a = {73,74,75,71,69,72,76,73};
        solution1.dailyTemperatures(a);
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
