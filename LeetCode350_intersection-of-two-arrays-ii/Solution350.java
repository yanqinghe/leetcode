import java.lang.reflect.Array;
import java.util.*;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<>();
        int index1 = 0;
        int index2 =0;
        while (index1<nums1.length&&index2<nums2.length){
            if(nums1[index1]==nums2[index2]){
                list.add(nums1[index1]);
                index2++;
                index1++;
            }else if(nums1[index1]<nums2[index2]){
                index1++;
            }else {
                index2++;
            }
        }
        int[] ret = new int[list.size()];
        int index =0;
        for (Integer i : list) {
            ret[index++]=i;
        }
        return ret;
    }
}
