package Search_in_Rotated_Sorted_Array_33;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr={3,1};

        System.out.println(solution.search(arr,1));
    }
    public int search(int[] nums, int target) {
        if(nums.length<1||nums==null){
            return -1;
        }
        if(nums.length== 1){
            if(nums[0]==target){
                return 0;
            }else {
                return -1;
            }
        }
        return find(0,nums.length-1,nums,target);
    }
//    特殊的二分法递归
    public int find(int i,int j,int[] nums,int target){
        if(i==j){
            if(nums[i]==target){
                return i;
            }else return -1;
        }
        int mid =(j+i)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>=nums[i]){
//          说明mid和i在同一个区域
            if(target<nums[mid]){
                return binarySearch(i,mid,nums,target)+find(mid+1,j,nums,target)+-1;
            }else{
                return find(mid+1,j,nums,target);
            }
        }else{
//            mid和j在同一个区域
            if(target<nums[mid]){
                return find(i,mid,nums,target);
            }else{
                return binarySearch(mid+1,j,nums,target);
            }
        }
    }

//    普通的二分法递归
    public int binarySearch(int i,int j,int[] nums,int target){
        if(i==j){
            if(nums[i]==target){
                return i;
            }else return -1;
        }
        int mid =(j+i)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target){
            return  binarySearch(i,mid,nums,target);
        }else {
            return  binarySearch(mid+1,j,nums,target);
        }
    }
}
