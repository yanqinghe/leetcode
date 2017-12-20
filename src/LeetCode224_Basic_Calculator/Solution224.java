import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Stack;

public class Solution224 {

    public static void main(String[] args) {
        Solution224 solution224 = new Solution224();
        solution224.calculate("(1+(4+5+2)-3)+(6+8)");
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0, sign = 1;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += num * sign;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                res += num * sign;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += num * sign;
                res = res * stack.pop() + stack.pop();
                num = 0;
                sign = 1;
            }
        }
        if (num != 0) {
            res += num * sign;
        }
        return res;
    }

}
