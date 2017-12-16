
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<=right){
            if(left==right)
                return left;
            int mid=(left+right)/2;
            if(nums[mid]<nums[mid+1])
                left=mid+1;
            else
                right=mid;
        }
        return right;
    }
}
