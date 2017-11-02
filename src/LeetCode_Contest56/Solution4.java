package LeetCode_Contest56;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums = {1, 3, 1};

        int res = solution4.smallestDistancePair(nums, 1);
        System.out.println(res);
    }

    public int smallestDistancePair(int[] nums, int k) {
        int leftBound = 0;
        int rightBound = 1000000;
        Arrays.sort(nums);
        while (leftBound < rightBound) {
            //获取中间值
            int midDis = (leftBound + rightBound) >> 1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int leftIndex = 0;
                int rightIndex = nums.length;
                while (leftIndex < rightIndex) {
                    int midIndex = (leftIndex + rightIndex) >> 1;
                    if (nums[midIndex] > (midDis + nums[i])) {
                        rightIndex = midIndex;
                    } else {
                        leftIndex = midIndex + 1;
                    }
                }
                rightIndex--;
                count += (rightIndex - i);
            }
            if (count < k) {
                leftBound = midDis + 1;

            } else {
                rightBound = midDis;
            }
        }
        return leftBound;
    }
}
