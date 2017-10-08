# LeetCode70 Climbing Stairs

## 问题描述

>You are climbing a stair case. It takes n steps to reach to the top.

>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

>**Note**: Given n will be a positive integer.

## 简单分析

这道题是比较经典的动态规划的题目，爬楼梯。采用动态规划的算法。动态规划的变量保存当前阶梯和上一阶梯的可行解，

## 代码如下

``` java

public int climbStairs(int n) {
    int [] dp= new int[2];
    dp[0]=1;
    dp[1]=1;
    for(int i=2;i<=n;i++){
        dp[i&1]+=dp[(i+1)&1];
    }
    return dp[n&1];
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678


