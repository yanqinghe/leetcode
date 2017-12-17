package LeetCode217_Contains_Duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length<1) return false;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num: nums
             ) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {
        if(nums==null||nums.length<1) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}
