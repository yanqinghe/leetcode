# LeetCode66 Plus One

## 问题描述

>Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.

## 简单分析

在网上看到这道题是谷歌很喜欢的面试题，不是很理解。这道题就是对数组的每一个元素进行加1，跟之前的
[LeetCode43 Multiply Strings](http://blog.csdn.net/yanqinghe123/article/details/78079569) 
有十分相似的地方，就是进位。
其实很多想加题目主要考虑的就是进位的问题。

这里因为数组的长度是固定的，如果在最高位发生进位的话，也就是比之前多了一位，那么就需要重新声明一个新的数组。

## 代码如下

``` java

public int[] plusOne(int[] digits) {
    if(digits == null || digits.length==0){
        return digits;
    }
    int help = 1;
    for (int i = digits.length-1; i >= 0; i--) {
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


```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
