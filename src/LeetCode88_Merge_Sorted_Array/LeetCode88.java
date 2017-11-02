package LeetCode88_Merge_Sorted_Array;

public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int all = m + n - 1;
        m--;
        n--;
        while (m >= 0 || n >= 0) {
            if (n < 0 || (m >= 0 && nums1[m] >= nums2[n])) {
                nums1[all] = nums1[m];
                m--;
                all--;
                continue;
            }
            if (m < 0 || (n >= 0 && nums1[m] < nums2[n])) {
                nums1[all] = nums2[n];
                n--;
                all--;
                continue;
            }
        }
    }
}
