package LeetCode128_Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n:nums
             ) {
            set.add(n);
        }
        int max =0;
        for (int n:nums
             ) {
            if(set.remove(n)){
                int left =n-1, right =n+1;
                while (set.remove(left)) left--;
                while (set.remove(right)) right++;
                max=Math.max(max,right-left-1);
            }
        }
        return max;
    }
}
