import java.lang.reflect.Array;
import java.util.*;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if(set.contains(i)) set2.add(i);
        }
        int[] ret= new int[set2.size()];
        int index =0;
        for (Integer i : set2) {
            ret[index++]=i;
        }
        return ret;
    }
}
