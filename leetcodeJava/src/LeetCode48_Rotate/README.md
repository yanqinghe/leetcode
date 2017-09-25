# Rotate Image

## 问题描述

>You are given an n x n 2D matrix representing an image.

>Rotate the image by 90 degrees (clockwise).

>Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
```
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
```

rotate the input matrix in-place such that it becomes:
```
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```
Example 2:

Given input matrix =
```
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
```

rotate the input matrix in-place such that it becomes:
```
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```

## 简单分析

这道题就是把给定的矩阵进行顺时针90度旋转。只是简单的数组操作，但是也有两种解法。

一种解法是直接对数组进行90度旋转赋值，代码如下。

``` java
public void rotate(int[][] matrix) {
        int length = matrix.length;
        int iMax = length>>1;
        for(int n=0;n<=iMax;n++){
            int l = length-(n<<1);
            for(int i=0;i<l-1;i++){
                //将第一行的数据保留下来
                int temp=matrix[n][length-1-n-i];
                //将左边旋转移到上边
                matrix[n][length-1-n-i]=matrix[i+n][n];
                //将底边转移到左边
                matrix[i+n][n]=matrix[length-1-n][i+n];
                //将右边转移到底边
                matrix[length-1-n][i+n]=matrix[length-1-n-i][matrix.length-1-n];
                //将上边的值转移到右边
                matrix[length-1-n-i][length-1-n]=temp;
            }
         }
    }
```

另外一种是LeetCode中排名靠前的一种方法，

1. 首先对矩阵按照对角线进行镜像处理，
2. 然后在按照中轴线进行翻转。


这样得到的也是旋转90度的结果。
读者可以自己实现一下代码，感觉两种算法没有优劣之分，都差不多。

LeetCode学习笔记持续更新。
GitHub地址https://github.com/yanqinghe/leetcode


