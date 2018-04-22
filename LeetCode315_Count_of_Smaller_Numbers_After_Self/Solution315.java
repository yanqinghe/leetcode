import java.lang.reflect.Array;
import java.util.*;

public class Solution315 {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.add(0);
//        stack.add(1);
//        stack.add(2);
//        stack.add(3);
//        Stack<Integer> stack1 = new Stack<>();
//        stack1.add(4);
//        stack1.add(5);
//        stack.addAll(stack1);
//        while (!stack.isEmpty())
//            System.out.println(stack.pop());
        Solution315 solution315 = new Solution315();
        solution315.countSmaller1(new int[]{-693, 1382, 9774
        });
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integers.add(i * 10);
        }
//        System.out.println(Collections.binarySearch(integers,32));

    }

    /**
     * 枚举法。时间复杂度为O(n^2)，无法通过
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 1) return res;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            Stack<Integer> tempStack = new Stack<>();
            int size = stack.size();
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                tempStack.add(stack.pop());
            }
            res.add(size - tempStack.size());
            stack.add(nums[i]);
            while (!tempStack.isEmpty())
                stack.add(tempStack.pop());
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 上述算法中因为寻找插入位置使用的是遍历，考虑采用二分法进行查找
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] smaller = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            //省略len-1，因为最后一个肯定为0
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[i] > nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            smaller[i] = nums.length - left;
            int temp = nums[i];
            for (int j = i; j < right; j++) {
                nums[j] = nums[j + 1];
            }
            nums[right] = temp;
        }
        for (int i : smaller) {
            res.add(i);
        }
        return res;
    }


    /**
     * 未通过
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller2(int[] nums){
        List<Integer> res = new ArrayList<>();
        List<Integer> numsMirror = new ArrayList<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            int index = Collections.binarySearch(numsMirror,nums[i]);
            if(index<0) index = -index-1;
            res.add(index);
            if(index==numsMirror.size()) numsMirror.add(nums[i]);
            else numsMirror.add(index,nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
   }
