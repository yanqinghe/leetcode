package LeetCode78_Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        if(nums==null||nums.length<1){
            return  result;
        }
        help(new ArrayList<>(),0,0,nums);
        return result;
    }
    List<List<Integer>> result = new ArrayList<>();
    private void help(List<Integer> list,int from,int l,int[] nums){
        if(l==nums.length){
            return;
        }else {

            for (int i = from; i < nums.length; i++) {
                list.add(nums[i]);
                result.add(new ArrayList<>(list));
                help(list,i+1,l+1,nums);
                list.remove(list.size()-1);
            }
        }
    }
}
