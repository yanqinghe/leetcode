# Unique Paths II

## 问题描述

> Follow up for "Unique Paths":

> Now consider if some obstacles are added to the grids. How many unique paths would there be?

> An obstacle and empty space is marked as 1 and 0 respectively in the grid.

> For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

```
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
```
>The total number of unique paths is 2.

>Note: m and n will be at most 100.

## 简单分析
这道题和之前的一道题LeetCode62 Unique Paths是相同的，只是在一些位置加入了障碍，这些障碍会减少可以通过的路径。算法基本和之前的是一样的，也是采用动态规划的方法，但是有一点不同的是，如果出现障碍，那么这个位置的可行解为0.

## 代码如下

``` java
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid[0].length;
    int[]dp = new int[n];
    //计算第一行
    dp[0]=1;
    //计算其余行
    for (int i = 0; i < obstacleGrid.length; i++) {
        for (int j = 0; j < n; j++) {
            if(obstacleGrid[i][j]==1){
                dp[j]=0;
            }else if(j>0){
                dp[j]+=dp[j-1];
            }
        }
    }
    return dp[n-1];
}

```

LeetCode学习笔记持续更新
GitHub地址 https://github.com/yanqinghe/leetcode
CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
