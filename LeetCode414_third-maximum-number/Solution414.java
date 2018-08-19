import java.util.*;

public class Solution414 {
    public static void main(String[] args) {
        Solution414 solution414 = new Solution414();
        System.out.println(solution414.thirdMax(new int[]{1,2}));
    }
    public int thirdMax(int[] nums) {
        int max = nums[0];
        PriorityQueue<Integer> queue = new PriorityQueue();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //遍历
            max=Math.max(num,max);
            if((queue.size()<3 || num>queue.peek())&&!set.contains(num)) {
                queue.add(num);
                set.add(num);
            }
            if(queue.size()>3){
                set.remove(queue.poll());
            }
        }
        if(queue.size()<3) return max;
        return queue.peek();
    }

}
