import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution227 {
    public static void main(String[] args) {
        Solution227 solution227  = new Solution227();
        solution227.calculate("1-1+1");
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Character> op = new Stack<>();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                val = val * 10 + c - '0';
            } else if(c=='+'||c=='-'||c=='*'||c=='/'){
                stack.add(val);
                val = 0;
                if(!op.isEmpty()&&(op.peek()=='*'||op.peek()=='/')){
                        stack.add(OP(op.pop(),stack.pop(),stack.pop()));
                }
                op.add(c);
            }
        }
        stack.add(val);
        if(!op.isEmpty()&&(op.peek()=='*'||op.peek()=='/')){
            stack.add(OP(op.pop(),stack.pop(),stack.pop()));
        }
        Queue<Integer> list = new LinkedList<>(stack);
        Queue<Character> queue1 = new LinkedList<>(op);
        val=list.poll();
        while (!list.isEmpty()){
            val = OP(queue1.poll(),list.poll(),val);
        }
        return val;

    }
    int OP(char op,int val1,int val2){
        switch (op){
            case '+':return val2+val1;
            case '-':return val2-val1;
            case '*':return val2*val1;
            case '/':return val2/val1;
        }
        return 0;
    }
}