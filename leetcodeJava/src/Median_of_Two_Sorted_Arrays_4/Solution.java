package Median_of_Two_Sorted_Arrays_4;

/**
 * Created by yanqinghe on 2017/7/2.
 */
public class Solution {
    public static void main(String[] args){
        int[] a={3};
        int[] b={1,2,4};
        Solution solution= new Solution();
        System.out.print(solution.findMedianSortedArrays(a,b));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length+nums2.length)%2==1){
            return findkth(nums1,nums2,(nums1.length+nums2.length)/2+1,0,0);
        }else{
            return (findkth(nums1,nums2,(nums1.length+nums2.length)/2,0,0)*1.0+
            findkth(nums1,nums2,(nums1.length+nums2.length)/2+1,0,0)*1.0)/2.0;
        }

    }
    int findkth(int[] nums1,int[] nums2,int k,int nums1P,int nums2P){
        int len1= nums1.length-nums1P;
        int len2=nums2.length-nums2P;

        //
        if (len1>len2){
            return findkth(nums2,nums1,k,nums2P,nums1P);
        }
        if(len1==0){
            return nums2[k-1];
        }
        if(k==1){
            return nums1[nums1P]<nums2[nums2P]?nums1[nums1P]:nums2[nums2P];

        }
        int nums1Index = k/2>len1?len1:k/2;
        int nums2Index = k-nums1Index;
        int c = nums1[nums1P+nums1Index-1] -nums2[nums2P+nums2Index-1];
        if(c==0){
            return nums1[nums1P+nums1Index-1];
        }else if(c<0){
            return findkth(nums1,nums2,k-nums1Index,nums1P+nums1Index,nums2P);
        }else{
            return findkth(nums1,nums2,k-nums2Index,nums1P,nums2P+nums2Index);
        }
    }
}
