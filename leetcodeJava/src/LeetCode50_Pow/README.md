#  Pow(x, n)

## 问题描述

>Implement pow(x, n).

## 简单分析

这道题的问题描述十分简单，就是自己实现一下pow(x,n）这个函数。对于幂函数，循环乘法是最简单的做法，但是效率太低了，那么有什么简单的做法吗？

根据一个基本定理
n看成是以2为基的位构成的，因此每一位是对应x的一个幂数，然后迭代直到n到最高位。比如说第一位对应x，第二位对应x*x,第三位对应x^4,...,第k位对应x^(2^(k-1))。

## 代码

``` java
public double myPow(double x, int n) {
    long m = n > 0 ? n : -(long)n;
    double ans = 1.0;
    while (m != 0) {
        if ((m & 1) == 1)
            ans *= x;
        x *= x;
        m >>= 1;
    }
    return n >= 0 ? ans : 1 / ans;
}
```


LeetCode学习笔记持续更新。

Github链接，https://github.com/yanqinghe/leetcode