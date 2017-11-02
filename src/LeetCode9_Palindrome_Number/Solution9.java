package LeetCode9_Palindrome_Number;

/**
 * Created by yanqinghe on 2017/7/5.
 */
public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome(-123321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int result = 0, a = x;
        while (x != 0) {
            if (result * 10 / 10 != result) return false;
            result = x % 10 + result * 10;
            x = x / 10;
        }
        return result == a ? true : false;
    }
}
