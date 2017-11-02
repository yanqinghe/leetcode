package LeetCode97_Interleaving_String;

public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null || s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (s1.length() + s2.length() != s3.length()) return false;
//        初始化动态规划的数组，dp[i][j]代表的是s1字符串的前i个字符和s2字符串的前j个字符与s3字符串的前i+j部分匹配
//        迭代公式为dp[i][j]
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[len1][len2];
    }
}
