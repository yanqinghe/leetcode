package LeetCode693_Binary_Number_with_Alternating_Bits;

public class Solution693 {
    public static void main(String[] args) {
        Solution693 solution693 = new Solution693();
        System.out.println(solution693.hasAlternatingBits(2));
    }

    public boolean hasAlternatingBits(int n) {
        boolean is = false;
        if ((n & 1) == 1) {
            is = false;
        } else {
            is = true;
        }
        while (n > 0) {
            if ((n & 1) == 1 && !is) {
                //如果最后一位为1且之前为0
                is = true;
                n = n >> 1;
            } else if ((n & 1) == 0 && is) {
                //如果最后以为为0且之前为1
                is = false;
                n = n >> 1;
            } else {
                //如果以上都不满足
                return false;
            }
        }
        return true;
    }
}
