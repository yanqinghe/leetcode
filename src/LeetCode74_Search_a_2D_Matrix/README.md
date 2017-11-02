# LeetCode74 Search a 2D Matrix

## 问题描述

> Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

>Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

>Consider the following matrix:

``` 

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

```

> Given target = 3, return true.

## 简单分析

这道题就是从二维数组里面找到相应的值，如果找到返回True,如果找不到返回False。
借鉴了二分法的思想，首先利用二分法确定在行数组里面，确定在某一行中以后在利用二分法从这一行数组中查找这个元素。二分法是比较经典的一个方法发，可以看下面的具体的代码

## 代码如下

``` java

public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix==null||matrix.length<1||matrix[0].length<1){
        return false;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    if(target>matrix[m-1][n-1]||target<matrix[0][0]){
        return false;
    }
    int left = 0,right = m-1;
    while (left<=right){
        int mid = (left+right)/2;
        int midVa = matrix[mid][n-1];
        if(midVa==target){
            return true;
        }else if(target<matrix[left][n-1]){
            //如果在left数组内,进入下一步收缩
            right=left;
            break;
        }else if(target<midVa){
            right=mid-1;
        }else if(target>midVa){
            left=mid+1;
        }
    }
    int l=0;
    int r = n-1;
    while(l<=r){
        int mid =(l+r)/2;
        int midVa = matrix[left][mid];
        if(target==midVa){
            return true;
        }else if(target<midVa){
            r=mid-1;
        }else if(target>midVa){
            l=mid+1;
        }
    }
    return false;
}
```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678

