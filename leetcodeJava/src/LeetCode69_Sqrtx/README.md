# LeetCode69 Sqrt(x)

## 问题描述

> Implement int sqrt(int x).

> Compute and return the square root of x.

## 简单介绍

这道题的就是实现sqrt方法。可以采用二分法进行，寻找适合的整数。但是网上很多博客都再说这个超出int范围的事情，我倒认为既然平方都是int范围内的，那么这个数字肯定也在int内，而数字肯定不大于46340（46341*46341>2147395600）。

所以我就直接把右边大于4630的数字砍掉了。不知道这算不算作弊。/(ㄒoㄒ)/~~

## 代码如下

``` java
public int mySqrt(int x) {
    if(x>=2147395600){
        return 46340;
    }
    int left=0,right =x/2+1;
    while(left<=right){
        int mid=(left+right)/2;
        int s;
        if(mid>46340){
            mid=46340;

        }s=mid*mid;
        if(s==x){
            return mid;
        }else if(s<x){
            left=mid+1;
        }else {
            right=mid-1;
        }
    }
    return right;
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
