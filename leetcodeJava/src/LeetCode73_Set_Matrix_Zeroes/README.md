# LeetCode73 Set Matrix Zeroes

## 问题描述

>Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

>click to show follow up.

>Follow up:
Did you use extra space?

>A straight forward solution using O(mn) space is probably a bad idea.

>A simple improvement uses O(m + n) space, but still not the best solution.

>Could you devise a constant space solution?

## 简单分析

这道题的目的是把零元素的行列都置为0，但是并不是连锁反应导致最后都是零。题目最后说到三种空间复杂度。

第一种， *O(mn)* 我认为是初始化一个大小为m*n数组，然后如果数组元素为0，在新的数组中行列置为0，这样就比较简单。

第二种，*O(m + n)* 我认为维护两个数组，长度分别为m和n，一个代表某一行是否应该置为0，另一个表示某一列是否应该置为0。第一次扫描完成以后根据两个数组的状态，把数组的行列元素置为0。

第三种，*O(1)* 要想这样话，就需要直接在原来的数组上下文章。可以用每一行的第一个元素和每一列的第一个元素代表该行和该列是否应该置为0。但是这样就存在一个问题，0行0列的元素为0的话不知道到底是行为零还是列为零。所以需要维护两个boolean常量，判断这种情况。

## 代码如下

``` java

public void setZeroes(int[][] matrix) {
    if(matrix==null||matrix.length<1){
        return;
    }
    boolean firstRowZero  = false;//状态
    boolean firstColZero  = false;//状态
    int m = matrix.length;
    int n = matrix[0].length;
    for (int temp: matrix[0]
            ) {
        if(temp==0){
            firstRowZero=true;
        }
        }
    for (int[] temp: matrix
            ) {
        if(temp[0]==0){
            firstColZero=true;
        }
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] == 0) {
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }
    for (int i = m - 1; i > 0; i--) {
        for (int j = n - 1; j > 0; j--) {
            if (matrix[0][j] == 0||matrix[i][0] == 0 ){
                matrix[i][j] = 0;
            }
        }
    }
    if(matrix[0][0]==0){
        firstColZero=firstRowZero=true;
    }
    if(firstColZero){
        for (int i = 0; i <m ; i++) {
            matrix[i][0]=0;
        }
    }
    if(firstRowZero){
        for (int i = 0; i < n; i++) {
            matrix[0][i]=0;
        }
    }
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
