# LeetCode79 Word Search

## 问题描述

>Given a 2D board and a word, find if the word exists in the grid.

>The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

>For example,
Given board =
```
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
```
>word = **"ABCCED"**, -> returns true,

>word = **"SEE"**, -> returns true,

>word = **"ABCB"**, -> returns false.

## 问题分析

这道题我感觉就是简单的考验对数组的操作，因为还有一个状态的问题，所以，需要保存整个二维数组的状态来代表这个单元格的元素有没有被使用。

其中需要多考虑到的一点是避免出现越界的情况。

## 代码如下

``` java
public boolean exist(char[][] board, String word) {
    if(board==null||board.length<1||board[0].length<1){
        return false;
    }
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if(board[i][j]==word.charAt(0)){
                boolean[][] dp = new boolean[m][n];
                dp[i][j]=true;
                help(board,word,dp,1,i,j);
                if (result) {
                    return result;
                }
            }
        }
    }
    return  result;
}
boolean result  =false;
private void  help(char[][] board,String word,boolean[][] dp,int index,int i,int j){
    if(index==word.length()){
        result=true;
    }else {
        if(result==true){
            return;
        }
        if(i<board.length-1&&board[i+1][j]==word.charAt(index)&& !dp[i+1][j]){
            dp[i+1][j]=true;
            help(board,word,dp,index+1,i+1,j);
            dp[i+1][j]=false;
        }
        if(j<board[0].length-1&&board[i][j+1]==word.charAt(index)&& !dp[i][j+1]){
            dp[i][j+1]=true;
            help(board,word,dp,index+1,i,j+1);
            dp[i][j+1]=false;
        }
        if(i>0&&board[i-1][j]==word.charAt(index)&& !dp[i-1][j]){
            dp[i-1][j]=true;
            help(board,word,dp,index+1,i-1,j);
            dp[i-1][j]=false;
        }
        if(j>0&&board[i][j-1]==word.charAt(index)&&!dp[i][j-1]){
            dp[i][j-1]=true;
            help(board,word,dp,index+1,i,j-1);
            dp[i][j-1]=false;
        }
    }
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
