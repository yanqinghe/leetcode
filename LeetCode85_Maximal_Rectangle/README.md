#LeetCode85 Maximal Rectangle

问题来源 [LeetCode85](https://leetcode.com/problems/maximal-rectangle/description/)

## 问题描述

>Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

>For example, given the following matrix:
```
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```
>Return **6**.

## 问题分析

这道题目其实和[LeetCode84](http://blog.csdn.net/yanqinghe123/article/details/78244339)有很大的关系。比如题目给定的矩阵。
```
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```

可以转化成

```
1 0 1 0 0
2 0 2 1 1
3 1 3 2 2
4 0 0 3 0
```
也就是把每列连续的1 加起来，形成新的列，而矩形的面积可以通过Rectangle in Histogram的规则计算出来。

比如第3行的 **3 2 2** 就是给定矩阵的最大矩形，也就是2 +2 +2 =6。

所以解决这道题的方法就是先把给矩阵的每一行转化，然后利用84题的算法进行计算，并保存最大值。

## 代码如下

``` java
public int maximalRectangle(char[][] matrix) {
    if(matrix==null|| matrix.length<1 ||matrix[0].length<1)
        return 0;
    int m =matrix.length;
    int n  = matrix[0].length;
    for(int i=1;i<m;i++){
        for (int j = 0; j < n; j++) {
            if(matrix[i][j]!='0'){
                matrix[i][j]=(char)(matrix[i][j]+matrix[i-1][j]-'0');
            }

        }
    }
    int max =0;
    for (int i = 0; i < m; i++) {
        max =Math.max(max,largestRectangleArea(matrix[i]));
    }
    return max;

}
public int largestRectangleArea(char[] heights) {
    if(heights==null ||heights.length<1){
        return 0;
    }
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    stack.add(-1);
    for(int i=0;i<heights.length;i++){
        while(stack.size()!=1 && heights[stack.peek()]>=heights[i]){
            result = Math.max((heights[stack.pop()]-'0')*(i-stack.peek()-1),result);
        }
        stack.add(i);
    }
    int right = stack.peek();
    while (stack.size()>1){
        result  = Math.max((heights[stack.pop()]-'0')*(right-(stack.peek())),result);
    }
    return result;
}
```
LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678



