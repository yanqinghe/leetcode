import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k<=0) return new int[0];
        int[] max = new int[nums.length-k+1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                //如果新加入的元素大于队列尾部的元素，那么移除队列尾部的元素
                deque.removeLast();
            }
            //将新的元素添加进来
            deque.offerLast(i);
            //这样队列头部的位置就是最大值
            if(i>=k-1) max[i+1-k]=nums[deque.peek()];
        }
        return max;
    }

 }
