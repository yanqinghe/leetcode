import java.util.Stack;

class MyQueue {
    Stack<Integer> integers;
    /** Initialize your data structure here. */
    public MyQueue() {
        integers = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while (!integers.isEmpty()){
            temp.add(integers.pop());
        }
        integers.add(x);
        while (!temp.isEmpty()){
            integers.add(temp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return integers.pop();
    }

    /** Get the front element. */
    public int peek() {
        return integers.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return integers.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */