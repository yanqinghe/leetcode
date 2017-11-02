package LeetCode38_Count_and_Say;

public class Solution38 {
    public static void main(String[] args) {
        Solution38 solution = new Solution38();
        System.out.println(solution.countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n < 2) {
            return "1";
        }
        return helper("1", 2, n).toString();

    }

    public StringBuffer helper(String str, int i, int limit) {
        if (i > limit) {
            return new StringBuffer(str);
        }
        char pre = str.charAt(0);
        char m = '1';
        StringBuffer result = new StringBuffer();
        for (int j = 1; j < str.length(); j++) {
            if (str.charAt(j) == pre) m++;
            else {
                result.append(m);
                result.append(pre);
                pre = str.charAt(j);
                m = '1';
            }
        }
        result.append(m);
        result.append(pre);
        return helper(result.toString(), i + 1, limit);
    }
}