package LeetCode151_Reverse_Wordsin_a_String;

import java.util.Stack;

public class Solution151 {
    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        solution151.reverseWords("a");
    }
    public String reverseWords(String s) {
        if(s==null||s.length()<1) return s;
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int begin=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                String temp = s.substring(begin,i);
                if(temp.length()>0){
                    stack.add(temp);
                }
                begin=i+1;
            }
        }
        if(begin<s.length()){
            stack.add(s.substring(begin,s.length()));
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop()).append(' ');
        }
        if(res==null||res.length()<1) return res.toString();
        return res.deleteCharAt(res.length()-1).toString();
    }
}
