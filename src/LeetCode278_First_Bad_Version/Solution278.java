public class Solution278 {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int ver = 0;
        while (low < high) {
            ver = low + (high - low) / 2;
            if (isBadVersion(ver)) {
                high = ver;
            } else {
                low = ver + 1;
            }
        }
        return low;
    }
    boolean isBadVersion(int version){
        return true;
    }
}
