import java.util.*;

public class Solution496 {
    public static void main(String[] args) {
        Solution496 solution496 = new Solution496();
        System.out.println(solution496.nextGreaterElement(new int[]{
            4,1,2
        },new int[]{
            1,3,4,2
        }));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
          for (int i : nums2) {
            while (!queue.isEmpty()&&queue.peek()<i){
                map.put(queue.poll(),i);
            }
              queue.add(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
