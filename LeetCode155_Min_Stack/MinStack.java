
import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
    private   Stack<Integer> integers;
    private Stack<Integer> min;
    public MinStack() {
        this.integers = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        this.integers.add(x);
        if(min.isEmpty()){
            this.min.add(x);
        }else {
            this.min.add(Math.min(x,min.peek()));
        }
    }

    public void pop() {
        this.integers.pop();
        this.min.pop();
    }

    public int top() {
        return  this.integers.peek();
    }

    public int getMin() {
        return this.min.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
