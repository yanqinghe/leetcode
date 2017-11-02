package LeetCode_Contest56;

public class Solution1 {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        boolean isOne = false;
        for (int i = 0; i < bits.length - 1; i++) {
            if (isOne == true) {
                isOne = false;
                continue;
            }
            if (bits[i] == 1) {
                isOne = true;
                continue;
            }
        }
        if (isOne) {
            return false;
        } else {
            return true;
        }
    }
}
