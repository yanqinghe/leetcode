## LeetCode67 Add Binary

## 问题描述

> Given two binary strings, return their sum (also a binary string).

>For example,
``` a = "11" ```
```b = "1" ```
Return ```"100"```.

## 简单分析

这道题目其实就求两个字符串和的变种形式。只是求得是2进制格式，一样需要考虑两个字符串的长短问题，进位问题，还有最高位的问题。就不详细分析了，可以看下面的代码

## 代码如下

``` JAVA
public String addBinary(String a, String b) {
    int d = a.length()-b.length();
    if(d<=0){
        return  help(a,b,-d);
    }else {
        return help(b,a,d);
    }
}
private String help(String s,String l,int d){
    StringBuilder stringBuilder = new StringBuilder();
    int help = 0;
    for(int i=s.length()-1;i>=0;i--){
        int digit = (int)(s.charAt(i)-'0'+l.charAt(i+d)-'0')+help;
        stringBuilder.append(digit%2);
        help=digit/2;
    }
    for(int i=d-1;i>=0;i--){
        int digit =(int)(l.charAt(i)-'0')+help;
        stringBuilder.append(digit%2);
        help=digit/2;
    }
    if(help==1){
        stringBuilder.append(1);
    }
    return stringBuilder.reverse().toString();
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678



