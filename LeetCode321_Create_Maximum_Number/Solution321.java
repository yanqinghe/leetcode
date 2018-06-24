import java.lang.reflect.Array;
import java.util.*;

public class Solution321 {
    public static void main(String[] args) {
        Solution321 solution321 = new Solution321();
//        System.out.println(Arrays.toString(solution321.maxNumber(new int[]{3, 4, 6, 5},new int[]{9, 1, 2, 5, 8, 3},5)));
//        System.out.println(Arrays.toString(solution321.maxNumber(new int[]{6,7},new int[]{6,0,4},5)));//[6,7,6,0,4]
//        System.out.println(Arrays.toString(solution321.maxNumber(new int[]{3,4,6,5},new int[]{9,1,2,5,8,3},5)));//[9, 8, 6, 5, 3]
//        System.out.println(Arrays.toString(solution321.maxNumber(new int[]{2,5,6,4,4,0},new int[]{7,3,8,0,6,5,7,6,2},15)));//[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]
//        System.out.println(Arrays.toString(solution321.maxNumber(new int[]{1,6,5,4,7,3,9,5,3,7,8,4,1,1,4},new int[]{4,3,1,3,5,9},21)));//[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]
//        System.out.println(Arrays.toString(solution321.maxNumber(new int[]{5,1,0},new int[]{5,2,1},3)));//[7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]

//        System.out.println(Arrays.toString(solution321.maxNumber(
//                new int[]{2,0,2,1,2,2,2,2,0,1,0,0,2,0,2,0,2,1,0,1,1,0,1,0,1,2,1,1,1,0,1,2,2,1,0,0,1,2,1,2,2,1,1,0,1,2,0,2,0,1,2,0,2,1,1,1,2,0,0,1,0,2,1,2,0,1,0,0,0,1,2,1,0,1,1,2,0,2,2,0,0,1,1,2,2,1,1,2,2,1,0,1,2,0,1,2,2,0,0,0,2,0,2,0,2,2,0,1,1,1,1,2,2,2,2,0,0,2,2,2,2,0,2,0,1,0,0,2,1,0,0,2,0,2,1,1,1,1,0,1,2,0,2,1,0,1,1,1,0,0,2,2,2,0,2,1,1,1,2,2,0,0,2,2,2,2,2,0,2,0,2,0,2,0,0,1,0,1,1,0,0,2,1,1,2,2,2,1,2,2,0,0,2,1,0,2,1,2,1,1,1,0,2,0,1,1,2,1,1,0,0,1,0,1,2,2,2,0,2,2,1,0,1,2,1,2,0,2,2,0,1,2,2,1,2,2,1,1,2,2,2,2,2,1,2,0,1,1,1,2,2,2,0,2,0,2,0,2,1,1,0,2,2,2,1,0,2,1,2,2,2,0,1,1,1,1,1,1,0,0,0,2,2,0,1,2,1,0,0,2,2,2,2,1,0,2,0,1,2,0}
//               ,new int[]{1,1,1,0,0,1,1,0,2,1,0,1,2,1,0,2,2,1,0,2,0,1,1,0,0,2,2,0,1,0,2,0,2,2,2,2,1,1,1,1,0,0,0,0,2,1,0,2,1,1,2,1,2,2,0,2,1,0,2,0,0,2,0,2,2,1,0,1,0,0,2,1,1,1,2,2,0,0,0,1,1,2,0,2,2,0,1,0,2,1,0,2,1,1,1,0,1,1,2,0,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,0,0,1,2,1,2,0,1,2,2,1,1,0,1,2,1,0,0,1,0,2,2,1,2,2,0,0,0,2,0,0,0,1,0,2,0,2,1,0,0,1,2,0,1,1,0,1,0,2,2,2,1,1,0,1,1,2,1,0,2,2,2,1,2,2,2,2,0,1,1,0,1,2,1,2,2,0,0,0,0,0,1,1,1,2,1,2,1,1,0,1,2,0,1,2,1,2,2,2,2,0,0,0,0,2,0,1,2,0,1,1,1,1,0,1,2,2,1,0,1,2,2,1,2,2,2,0,2,0,1,1,2,0,0,2,2,0,1,0,2,1,0,0,1,1,1,1,0,0,2,2,2,2,0,0,1,2,1,1,2,0,1,2,1,0,2,0,0,2,1,1,0,2,1,1,2,2,0,1,0,2,0,1,0}
//            ,
//        600)));
//        System.out.println(Arrays.toString(solution321.maxNumber(
//                new int[]{3,3,3,2,3,7,3,8,6,0,5,0,7,8,9,2,9,6,6,9,9,7,9,7,6,1,7,2,7,5,5,1},
//        new int[]{5,6,4,9,6,9,2,2,7,5,4,3,0,0,1,7,1,8,1,5,2,5,7,0,4,3,8,7,3,8,5,3,8,3,4,0,2,3,8,2,7,1,2,3,8,7,6,7,1,1,3,9,0,5,2,8,2,8,7,5,0,8,0,7,2,8,5,6,5,9,5,1,5,2,6,2,4,9,9,7,6,5,7,9,2,8,8,3,5,9,5,1,8,8,4,6,6,3,8,4,6,6,1,3,4,1,6,7,0,8,0,3,3,1,8,2,2,4,5,7,3,7,7,4,3,7,3,0,7,3,0,9,7,6,0,3,0,3,1,5,1,4,5,2,7,6,2,4,2,9,5,5,9,8,4,2,3,6,1,9},
//        160)));
//        System.out.println(Arrays.toString(solution321.maxNumber(
//        new int[]{5,0,2,1,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3},
//        new int[]{7,6,7,1,0,1,0,5,6,0,5,0},
//        31)));
        System.out.println(Arrays.toString(solution321.maxNumber(
        new int[]{2,1,2,1,2,2,1,2,2,1,1,2,1,0,2,0,1,0,1,1,2,0,0,2,2,2,2,1,1,1,2,1,2,0,2,0,1,1,0,1,0,2,0,1,0,2,0,1,1,0,0,2,0,1,1,2,0,2,2,1,2,1,2,1,0,1,2,0,2,1,2,2,2,0,1,1,0,2,0,1,1,0,0,0,2,1,1,1,0,1,1,0,1,2,1,2,0,0,0,2,1,2,2,1,1,0,1,1,0,0,1,0,0,0,2,1,1,0,2,0,2,2,0,2,0,0,2,0,1,2,1,1,1,2,1,0,1,1,0,2,1,2,2,1,0,1,1,1,2,0,2,2,2,0,2,1,1,2,1,1,2,0,2,1,0,2,0,0,2,2,2,0,2,1,2,2,1,2,1,2,2,2,1,1,2,0,2,0,0,2,2,2,0,2,2,1,0,0,2,2,2,1,1,0,2,1,0,1,2,1,1,2,2,1,1,0,2,1,2,2,1,2,1,0,0,0,0,1,1,0,2,2,2,2,2,2,2,2,1,1,0,2,1,0,0,0,0,2,1,1},
        new int[]{1,1,0,2,0,1,1,1,0,2,2,2,1,1,0,1,2,1,2,1,0,1,2,2,2,2,1,1,0,2,0,1,0,0,1,1,0,1,2,1,2,1,2,0,1,1,1,1,2,0,1,1,1,0,0,1,0,1,2,1,1,0,2,2,1,2,0,2,0,1,1,2,0,1,1,2,2,1,0,1,2,2,0,1,1,2,2,0,2,2,0,2,1,0,0,2,1,0,0,2,1,2,1,2,0,2,0,1,1,2,1,1,1,2,0,2,2,0,2,2,0,2,1,2,1,2,0,2,0,0,1,2,2,2,2,1,2,2,0,1,0,0,2,2,2,2,0,1,0,2,1,2,2,2,1,1,1,1,2,0,0,1,0,0,2,2,1,0,0,1,1,0,0,1,1,0,2,2,2,2,2,1,0,2,2,0,0,1,0,0,1,1,1,2,2,0,0,2,0,0,0,1,2,0,2,0,1,2,0,1,2,0,1,1,0,0,1,2,1,0,2,1,0,1,2,0,1,1,2,1,0,2,1,2,1,1,0,2,2,1,0,2,1,1,1,0,0,0,1,0},
        500)));
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        Arrays.fill(max,0);
        for (int i = 0; i <= nums1.length; i++) {
            for (int j = 0; j <= nums2.length; j++) {
                if(i+j==k){
                    int[] temp1 = getMaxArray(Arrays.copyOf(nums1,nums1.length),i);
                    int[] temp2 = getMaxArray(Arrays.copyOf(nums2,nums2.length),j);
                    int[] temp3 = productMaxArray(temp1,temp2,k);
                    max=maxArr(temp3,max);
                }
            }
        }
        return max;
    }
    int[] maxArr(int[] nums1,int[] nums2){
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]<nums2[i])
                return nums2;
            if(nums1[i]>nums2[i])
                return nums1;
        }
        return nums1;
    }

    int[]  productMaxArray(int[] nums1,int[] nums2,int k){
        if(nums1==null) return nums2;
        if(nums2==null) return nums1;

        int[] nums = new int[k];

        int left = 0;
        int right = 0;
        int index =0;

        while (left<nums1.length&&right<nums2.length){
            int ln = nums1[left];
            int rn = nums2[right];
            if(ln>rn){
                nums[index++] = ln;
                left++;
            }else if(ln<rn){
                nums[index++]=rn;
                right++;
            }else {
                //如果出现相等的情况
                int eqNum = nums1[left];
                int leftIndex = left;
                int rightIndex = right;
                int isEnd = 0;
                while (leftIndex<nums1.length&&rightIndex<nums2.length){
                    if(nums1[leftIndex]>nums2[rightIndex]){
                        isEnd=1;
                        break;
                    }else if(nums1[leftIndex]<nums2[rightIndex]){
                        isEnd=-1;
                        break;
                    }else {
                        if(leftIndex-left>1){
                            if(nums1[leftIndex-2]>nums1[leftIndex]){
                                //如果减少
                                index--;
                                leftIndex--;
                                break;
                            }
                        }else if(leftIndex-left==1){
                            if(nums1[leftIndex-1]>nums1[leftIndex]){
                                //递减
                                break;
                            }
                        }
                        nums[index++]=nums1[leftIndex++];
                        rightIndex++;
                    }
                }
                if(isEnd==0){
                    if(leftIndex<nums1.length) isEnd=1;
                    else  isEnd=-1;
                }
                if(isEnd==1){
                    left=leftIndex;
                }
                if(isEnd==-1){
                    right=rightIndex;
                }
            }
        }
        while (left<nums1.length){
            nums[index++]=nums1[left++];
        }
        while (right<nums2.length){
            nums[index++]=nums2[right++];
        }
        return nums;
    }

    int insertInto(List<Integer> nums,int start,int num){
        for (int j = start+1; j < nums.size(); j++) {
            if(num>nums.get(j)){

                nums.add(j,num);
                return j;
            }
        }
        nums.add(num);
        return nums.size()-1;
    }

    int[] getMaxArray(int[] nums,int m){
        if(m<=0) return null;
        int cnt = 0;
        int len = nums.length;
        int k = len-m;
        if(k==0) return nums;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <len ; i++) {
            //遍历每一位
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                if(cnt==k) return getRet(nums,m);
                //当stack不等于空且当前数字大于栈顶数字的时候
                //移除栈顶数字，并且把该数字删除
                nums[stack.pop()]=-1;
                cnt++;
                //如果已经完成剔除任务，直接返回
            }
            //如果stack为空，直接放入stack内
            //如果当前数字大于栈顶数字，那么也填入stack中
            stack.add(i);
        }
        for (; cnt < k; cnt++) {
            nums[stack.pop()]=-1;
        }
        return getRet(nums,m);
    }


    int[] getRet(int[] nums,int len){
        int[] newNums = new int[len];
        int i =0;
        for (int num : nums) {
            if(num>=0)
                newNums[i++]=num;
        }
        return newNums;
    }
}
