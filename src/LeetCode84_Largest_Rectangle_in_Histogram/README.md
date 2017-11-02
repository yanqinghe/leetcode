# LeetCode84 Largest Rectangle in Histogram

问题链接 [LeetCode84](https://leetcode.com/problems/largest-rectangle-in-histogram/description/)

## 问题描述

>Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

>![图片](https://leetcode.com/static/images/problemset/histogram.png)

>Above is a histogram where width of each bar is 1, given height = **[2,1,5,6,2,3]**.

>![图片](https://leetcode.com/static/images/problemset/histogram_area.png)

>The largest rectangle is shown in the shaded area, which has area = 10 unit.

>For example,
Given heights = **[2,1,5,6,2,3]**,
return **10**.

## 问题分析

这道题和之前那道盛水的题目有几分类似的样子，也是可以通过暴力破解的方式来解决，但是超时了。于是从网上找到了一种利用栈的算法。

### 算法描述:

1. 维护一个栈，要求栈自下而上是升序排列，在遍历给定数组的过程中吗，如果当前数组元素小于栈顶的元素。那么执行出栈操作，直到栈顶元素小于当前数组元素。
2. 如果执行出栈操作，那么如何计算出栈的元素所形成的矩形面积呢。经过分析可以看出面积为当前数组元素的坐标和出栈元素数组坐标的差乘以出栈元素的高度。
3. 如果遍历完栈不为空，那么需要从栈顶元素开始，对当前栈内所有的元素进行面积计算，计算公式为 = 出栈元素的高度 * （数组最后的坐标-元素出栈后的栈顶元素坐标）

因为在计算过程中会出现栈为空的现象，为了方便处理，在栈底放入坐标-1的元素，方便计算。

## 代码如下

``` java
public int largestRectangleArea(int[] heights) {
    if(heights==null ||heights.length<1){
        return 0;
    }
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    stack.add(-1);
    for(int i=0;i<heights.length;i++){
        while(stack.size()!=1 && heights[stack.peek()]>=heights[i]){
            //出栈直到栈顶元素小于当前元素或栈内元素只有一个
            //在出栈的过程中计算出栈元素形成的面积。因为已出站的元素肯定大于待出栈的元素，所以面积就是坐标差乘以待出栈的元素高度。
            result = Math.max(heights[stack.pop()]*(i-stack.peek()-1),result);
        }
        //当前元素入栈
        stack.add(i);
    }
    //遍历完后，如果栈不为空，取当前栈顶的坐标
    int right = stack.peek();
    while (stack.size()>1){
        //继续出栈，出栈元素的面积为（坐标right-未出栈栈顶坐标）*已出站元素高度
        result  = Math.max(heights[stack.pop()]*(right-(stack.peek())),result);
    }
    return result;

}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678

