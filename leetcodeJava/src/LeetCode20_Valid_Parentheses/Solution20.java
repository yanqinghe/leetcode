package LeetCode20_Valid_Parentheses;

import java.util.Stack;

/**
 * Created by hehe on 2017/7/18.
 */
public class Solution20 {
    public static void main(String[] args){
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid("()[]{}"));
    }
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack<Character>();
        if(s.length()==0||s.length()%2==1){
            return false;
        }
        sk.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(sk.isEmpty()){
                sk.push(s.charAt(i));
                continue;
            }
            int d = sk.peek()-s.charAt(i);
            if(d<0&&d>-3){
                sk.pop();
            }else{
                sk.push(s.charAt(i));
            }
        }
        if(sk.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
