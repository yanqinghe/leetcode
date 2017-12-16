
public class Solution69 {
    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        System.out.println("args = [" + solution69.mySqrt(2147395599) + "]");
    }

    public int mySqrt(int x) {
        if (x >= 2147395600) {
            return 46340;
        }
        int left = 0, right = x / 2 + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int s;
            if (mid > 46340) {
                mid = 46340;

            }
            s = mid * mid;
            if (s == x) {
                return mid;
            } else if (s < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}

