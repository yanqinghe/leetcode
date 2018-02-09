# LeetCode72 Edit Distance

## 问题描述

> Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

> You have the following 3 operations permitted on a word:

> a) Insert a character

> b) Delete a character

> c) Replace a character

## 简单分析

这道题是编辑距离，用来描述两个字符串之间一种关系的指数。表示从一个字符串变为另外一个字符串所需要的最小操作数。典型的动态规划问题。
迭代公式

**dp[i][j]=Math.min(dp[i][j],Math.min(dp[i-1][j]+1,dp[i][j-1]+1))**

其中*dp[i-1][j]+1*代表的添加操作，*dp[i][j-1]+1*代表的删除操作。右边的 **dp[i][j]=dp[i-1][j-1]+f(i,j)** 解释如下。

其中*f(i,j)*代表的是如果前面word1的*i-1*字符与word2的*j-1*字符相同，就不需要其他操作*f(i,j)=0*，否则的话需要进行替换操作*f(i,j)=1*

## 代码如下

``` java
public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m+1][n+1];
    for(int i=0;i<=n;i++){
        dp[0][i]= i;
    }
    for (int i = 0; i <= m; i++) {
        dp[i][0]=i;
    }
    for(int i =1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(word1.charAt(i-1)==word2.charAt(j-1)){
                //如果相等
                dp[i][j]=dp[i-1][j-1];
            }else {
                //如果不等
                dp[i][j]=dp[i-1][j-1]+1;
            }
            dp[i][j]=Math.min(dp[i][j],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));

        }
    }
    return dp[m][n];
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
