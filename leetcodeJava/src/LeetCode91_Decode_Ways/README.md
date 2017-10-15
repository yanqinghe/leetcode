#LeetCode91 Decode Ways

>  问题来源[LeetCode91](https://leetcode.com/problems/decode-ways/description/)

## 问题描述

>A message containing letters from A-Z is being encoded to numbers using the following mapping:
```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```
>Given an encoded message containing digits, determine the total number of ways to decode it.

>For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

>The number of ways decoding "12" is 2.

## 问题分析

这道题就是对给定的数字字符串进行解析，返回可能解的个数，看完这道题以后，因为出现多解的原因是连续两位可能解析为2个或者1个字符串，由此我联想到了[LeetCode70 Climbing Stairs](http://blog.csdn.net/yanqinghe123/article/details/78245231)，因为这两道题有一个非常相似的地方就是某一位的解由前两位决定。当然，也是采用动态规划的做法。

## 代码如下

``` java
public int numDecodings(String s) {
    if(s==null||s.length()<1||s.charAt(0)=='0'){
        return 0;
    }
    int [] dp = new int[2];
    dp[0]=1;
    dp[1]=1;
    for (int i = 1; i < s.length(); i++) {
        if(s.charAt(i)=='0'){
            if(s.charAt(i-1)=='0'||s.charAt(i-1)>'2'){
                return 0;
            }
            dp[1]=0;
        }
        int temp =dp[1];
        if((s.charAt(i-1)-'0')*10+s.charAt(i)-'0'<27){
            temp=temp+dp[0];
        }
        dp[0]=dp[1];
        dp[1]=temp;
    }
    return  dp[1];
}

```
LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
