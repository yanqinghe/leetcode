package LeetCode87_Scramble_String;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution87 {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            //如果长度不相同，直接返回false
            return false;
        if (s1.equals(s2))
            //如果相等，直接返回true
            return true;
        //字符串转化为字符数组
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        //进行字典排序
        Arrays.sort(c1);
        Arrays.sort(c2);
        //如果字典排序后不想等，返回false
        if (!Arrays.equals(c1, c2))
            return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        int length = s1.length();
        boolean[][][] dp = new boolean[length][length][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j < length - i + 1; j++) {
                for (int k = 0; k < length - i + 1; k++) {
                    for (int l = 1; l < i; l++) {
                        dp[j][k][i] |= dp[j][k][l] && dp[j + l][k + l][i - l] || dp[j][k + i - l][l] && dp[j + l][k][i - l];
                    }

                }
            }
        }

        return dp[0][0][length];
    }
}

