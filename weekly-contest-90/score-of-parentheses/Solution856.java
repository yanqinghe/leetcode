import java.util.Stack;

public class Solution856 {
    public static void main(String[] args) {
        Solution856 solution856 = new Solution856();
        System.out.println(solution856.scoreOfParentheses("()()"));
    }
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if(S.charAt(i)=='('){
                stack.push((int)'(');
            }else {
                int c = stack.pop();
                if(c=='('){
                    stack.push((int)'1');
                }else {
                    int cnt=c-'0';
                    while (stack.peek()!='('){
                        cnt+=(stack.pop()-'0');
                    }
                    stack.pop();
                    cnt *=2;
                    stack.push(cnt+'0');
                }
            }
        }
        int cnt=0;

        if(stack.size()==1){
            cnt= stack.peek()-'0';
        }else {
            while (!stack.isEmpty()){
                cnt+=(stack.pop()-'0');
            }
        }
        return cnt;


    }
}
