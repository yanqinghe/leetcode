package LeetCode43_Multiply_Strings;

public class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println("args = [" + solution43.multiply("1111", "222222") + "]");
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int num = 0;
        for (int i = num1.length() + num2.length() - 1; i >= 0; i--) {
            for (int j = Math.min(num1.length(), i) - 1; j >= 0; j--) {
                if (i - j <= num2.length()) {
                    num += (num1.charAt(j) - '0') * (num2.charAt(i - j - 1) - '0');
                }
            }
            if (i != 0 || num > 0)
                stringBuilder.append(num % 10);
            num = num / 10;
        }
        return stringBuilder.reverse().toString();
    }

}
