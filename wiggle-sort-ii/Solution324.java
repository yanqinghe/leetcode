import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution324 {
    public static void main(String[] args) {
        Solution324 solution324 = new Solution324();
        solution324.wiggleSort(new int[]{
                1, 3, 2, 2, 3, 1
        });
    }

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int K = (len+1)/2;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < len; i++) {
            priorityQueue.offer(nums[i]);
            if(priorityQueue.size()>K){
                priorityQueue.poll();
            }
        }
        //获取中位数
        int mid = priorityQueue.peek();
        if((len&1)==1){
            int small =0,large = len-2,index=0;
            while (index<len){
                if(nums[index]>mid){
                    //如果当前数大于中位数
                        swap(nums,index,large);
                        large-=2;
                        if(large<0) large=len-2;
                }else if(nums[index]<mid){
                        swap(nums,index,small);
                        small+=2;
                        if(small>=len) small=0;
                }else {
                    index++;
                }
            }
        }else {
            int small =len-2,large = 1,index=0;
            while (index<len){
                if(nums[index]>mid){
                    //如果当前数大于中位数
                        swap(nums,index,large);
                        large+=2;
                        if(large>=len) large=1;
                }else if(nums[index]<mid){
                        swap(nums,index,small);
                        small-=2;
                        if(small<=0) small=len-2;
                }else {
                    index++;
                }
            }
        }
        return;
    }
    private void swap(int[]ints,int i,int j){
//        i = (1+2*(i)) % (ints.length|1);
//        j=(1+2*(j)) % (ints.length|1);
        int temp = ints[i];
        ints[i]=ints[j];
        ints[j]=temp;
    }
    /**
     * 常规解法，使用排序算法对数组进行排序，从中间将数组一分为2，
     * 最后将两部分数组依次放入原数组
     * 时间复杂度为 O(nlogn)
     * @param nums
     */
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length+1;
        int[] nums1= Arrays.copyOfRange(nums,0,len/2);
        int[] nums2 = Arrays.copyOfRange(nums,len/2,len-1);
        for (int i = nums1.length - 1,j=0; i >= 0; i--,j+=2) {
            nums[j]=nums1[i];
        }
        for (int i = nums2.length - 1,j=1; i >= 0; i--,j+=2) {
            nums[j]=nums2[i];
        }

        return;
    }


}
