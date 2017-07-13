package Three_Sum_15;

import java.util.*;

/**
 * Created by hehe on 2017/7/13.
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr={-1, 0, 1, 2, -1, -4};
//        int[] arr={};
        System.out.print(solution.threeSum(arr));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length<3){
            return lists;
        }
        Arrays.sort(nums);
        Map<Integer,Integer> map= new HashMap<Integer,Integer>(){
            {
                for(int i =0;i<nums.length;i++){
                    put(nums[i],i);
                }
            }
        };
        for(int i=0;i<nums.length;i++){
            if(i==0||nums[i]==nums[i-1]){
                for(int j=i+1;j<nums.length;j++){
                    int temp = -(nums[i]+nums[j]);
                    if(map.get(temp)!=null&&map.get(temp)>j){
                        if(j>i+1&&nums[j]==nums[j-1]) continue;
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(temp);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }
}
