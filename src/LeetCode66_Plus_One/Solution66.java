
public class Solution66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int help = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = (digits[i] + help) % 10;
            help = (digits[i] + help) / 10;
            digits[i] = digit;
            if (help == 0)
                return digits;

        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;

    }

}
