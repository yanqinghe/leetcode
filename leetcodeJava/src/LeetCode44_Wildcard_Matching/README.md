# Wildcard Matching

## 问题描述

>Implement wildcard pattern matching with support for '?' and '*'.
>'?' Matches any single character.
>'*' Matches any sequence of characters (including the empty sequence).

>The matching should cover the entire input string (not partial).

>The function prototype should be:
bool isMatch(const char *s, const char *p)

>Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

## 解释

这道题也是字符串匹配的题目，LeetCode在第10道题目中也有一个字符串匹配，https://leetcode.com/problems/regular-expression-matching/

这个规则与上一个不同的是，用'?'号代替了之前的'.',比较关键的是'\*'这个符号与之前的意义不同，在这道题目中'\*'代表的是零个或者多个字符，也可以是不同的字符。这个就是问题的关键。在之前中可以很简单判断‘\*’所匹配的是否截止，但是在这里就不能简单的判断了。

举例如下

| a   | b   | c   | a   | d   | a   | d   | c   |
| --- | --- | --- | --- | --- | --- | --- | --- |
| a   | *   | d   |     |     |     |     |     |
| a   | *   | a   | d   |     |     |     |     |
| a   | *   | a   | d   | c   |     |     |     |


上面字符的匹配，因为ad出现了两次，'\*'的缘故就导致很难判断究竟是匹配到第一个ad还是第二个ad。

可以采用动态规划的方法，维护一个二维数组,dp[m][n]其中，m，n分别是两个字符串的长度，dp[i][j]的含义是字符串A的前i个字符和字符串b的前j个字符的匹配情况。

这样的话，匹配的时候就有两种情况

1. 如果字符串当前不为'\*'，那么只需要判断当前A，B字符串是否相同或者B字符串当前位置是不是‘？’
2. 如果字符串当前为'\*'，那么只需要判断 *dp[i-1][j]* 和 *dp[i][j-1]* 这两种情况。

##  代码示例 

``` java

public class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println("args = [" + solution43.multiply("1111","222222") + "]");
    }
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null){
            return null;
        }
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
            return "0";
        }
        StringBuilder stringBuilder= new StringBuilder();
        int num = 0;
        for(int i = num1.length()+num2.length()-1;i>=0;i--){
            for(int j = Math.min(num1.length(),i)-1;j>=0;j--){
                if(i-j<=num2.length()){
                    num+=(num1.charAt(j)-'0')*(num2.charAt(i-j-1)-'0');
                }
            }
            if(i!=0 || num>0)
                stringBuilder.append(num%10);
            num = num/10;
        }
        return stringBuilder.reverse().toString();
    }

}
```

LeetCode学习系列Github，持续更新。

https://github.com/yanqinghe/leetcode
