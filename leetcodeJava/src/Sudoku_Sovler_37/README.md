# Sudoku Solver

## 题目描述

> Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
![img1](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

>A sudoku puzzle...

>![img2](https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png)

>...and its solution numbers marked in red.

## 中文介绍
该题目就是在给定数独的基本条件以后，求出数独的解。因为对数独不是很了解，还专门查了一下数独是否是唯一解。

> 来源http://www.sudokufans.org.cn/forums/topic/573/

>首先我们可以看一道题目的提示数是否是少于17个的，若少于17个必然不可能唯一解。第二观察提示数，是否缺少两个提示数，因为缺少2个提示数的话，在终盘中这两个提示数的位置是可以互换的，则必然不可能是唯一解。第三看是否存在同一行大区块中是否两行都无提示数（例如第一行和第二行都没提示数），或者同一列大区块中是否两列都无提示数，这是无谜题图形中的一种，因为这两行/两列的数字是可以互换的，不可能是唯一解，若是整个大区块都无提示数则更可以判断是非唯一解了。其他还有一些无谜题图形，则更复杂些。

不知道LeetCode对于这个唯一解是什么考虑的。在后面的编程中没有考虑多解的情况，一次通过。

CSDN上一篇博主对于这个问题的评价
>http://blog.csdn.net/linhuanmars/article/details/20748761

>这道题的方法就是用在N-Queens中介绍的常见套路。简单地说思路就是循环处理子问题，是一个典型的np问题，所以在时间复杂度上就不用纠结了。
所以说针对这种题目，只需要合理的组织代码，用套路解决就可以了。下面直接列出相关代码。包括连个辅助函数。

``` java
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length !=9)
            return;
        helper(board,0,0);
    }
    private boolean helper(char[][] board,int i,int j){
        if(j>=9){
            //当j超过列数的时候，进入下一行
            return helper(board,i+1,0);
        }
        if(i==9){
            //完成操作返回
            return true;
        }
        if(board[i][j]!='.'){
            //如果当前填充的单元格有初始值，那么跳到下一个单元格
            return helper(board,i,j+1);

        }else {
            for(int m = 1;m<=9;m++){
                board[i][j]=(char)(m+'0');
                if(isValid(board,i,j)) {
//                    return helper(board, i, j++);
                    if (helper(board, i, j+1))
                        return true;
                }
                board[i][j]='.';
            }
        }
        return false;
    }
    private boolean isValid(char[][] board,int i,int j){
        //判断当前单元格填入的数字在是否满足行和列的两种要求
        for(int m=0;m<9;m++){
            if((m!=j&&board[i][m]==board[i][j])||(m!=i&&board[m][j]==board[i][j])){
                return false;
            }
        }
//        判断当前单元格填入的数字是否满足单元格内的要求
        for(int r=i/3*3;r<i/3*3+3;r++){
            for(int c =j/3*3;c<j/3*3+3;c++){
                if((r!=i || c!=j) && board[r][c]==board[i][j])
                    return false;
            }
        }
        return true;
    }
}


```
