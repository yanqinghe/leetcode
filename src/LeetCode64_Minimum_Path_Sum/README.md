# Minimum Path Sum

## 问题描述

> Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

> Note: You can only move either down or right at any point in time.

## 简单介绍

这道题是LeetCode63 LeetCode64的延续，之前是每一个单元格内的数字都是1，现在是每个单元格的内的数字是不同的，也就是成本不同，需要考虑得到最小和路径。
仍然是采用动态规划的方法。不过这里动态规划保存的不是可行解而是到达当前单元格的最小成本。
迭代公式是     ```dp[j]=grid[i][j]+Math.min(dp[j-1],dp[j])```

dp[j-1]代表的是j-1个单元格，也就是左边单元格 dp[j]代表的是i-1，也就是上一行的单元格。求两者的最小值。就是第i行的j个单元格的最小成本

## 代码如下

``` java
public int minPathSum(int[][] grid) {
    int m =grid.length;

    int n = grid[0].length;
    int [] dp  = new int[n];
    dp[0]=grid[0][0];
    for (int i = 1; i < n; i++) {
        dp[i]=dp[i-1]+grid[0][i];
    }
    for (int i = 1; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if(j==0){
                dp[j]+=grid[i][0];
            }else {
                dp[j]=grid[i][j]+Math.min(dp[j-1],dp[j]);
            }
        }
    }
    return dp[n-1];
}
```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678

