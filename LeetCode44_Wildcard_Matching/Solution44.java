
public class Solution44 {
    public static void main(String[] args) {
        String[][] str = {
                {"aa", "a"},//false
                {"aa", "aa"},//true
                {"aaa", "aa"},//false
                {"aa", "*"},//true
                {"aa", "a*"},//true
                {"ab", "?*"}, // true
                {"aab", "c*a*b"}, //false
                {"", "*"},//true
                {"a", "a*"},//True
                {"abefcdgiescdfimde", "ab*cd?i*de"},//true
                {"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"}//true
        };
        Solution44 solution44 = new Solution44();
        for (int i = 0; i < str.length; i++) {
            System.out.println("result = [" + solution44.isMatch(str[i][0], str[i][1]) + "]");
        }

    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            //如果p的当前字符不为'*'，那么只需要判断
            dp[0][j + 1] = dp[0][j] && p.charAt(j) == '*';
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    if (p.charAt(j) == '*') {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];

    }

}