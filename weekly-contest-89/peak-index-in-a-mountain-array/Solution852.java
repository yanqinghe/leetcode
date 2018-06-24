public class Solution852 {
    public int peakIndexInMountainArray(int[] A) {
        int ret = 0;
        for (int i = 1; i < A.length; i++) {
            if(A[i]<A[i-1]){
                ret = i-1;
                break;
            }
        }
        return ret;
    }
}
