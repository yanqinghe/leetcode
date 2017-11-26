package LeetCode150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length<1){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String str:tokens
             ) {
            if(str.length()==1){
                switch (str.charAt(0)){
                    case '+':
                        stack.add(stack.pop()+stack.pop());
                       continue;
                    case '-':
                        stack.add(-stack.pop()+stack.pop());
                        continue;
                    case '*':
                        stack.add(stack.pop()*stack.pop());
                        continue;
                    case '/':
                        stack.add((int)(1.0/stack.pop()*stack.pop()));
                        continue;

                }
            }
            stack.add(Integer.valueOf(str));
        }
        return stack.peek();
    }

}
