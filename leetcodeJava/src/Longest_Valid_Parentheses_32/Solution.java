package Longest_Valid_Parentheses_32;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.print(solution.longestValidParentheses("()(()"));
    }
    class Help{
        public Help(int index,char aChar){
            this.index=index;
            this.aChar=aChar;
        }
        int index;
        char aChar;
    }
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<2){
            return 0;
        }
        int result =0;
        Stack<Help> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            Help help = new Help(i,s.charAt(i));
            if(stack.isEmpty()){
                stack.add(help);
            }else if(help.aChar-stack.peek().aChar==1){
                stack.pop();
            }else stack.add(help);
        }
        stack.add(new Help(s.length(),s.charAt(s.length()-1)));
        result=stack.get(0).index-0;
        for(int i=0;i<stack.size()-1;i++){
            int temp =stack.get(i+1).index-stack.get(i).index-1;
            result= result<temp?temp:result;
        }
        return  result;
    }
}
