#Jump Game

## 问题描述

>Given an array of non-negative integers, you are initially positioned at the first index of the array.

>Each element in the array represents your maximum jump length at that position.

>Determine if you are able to reach the last index.

>For example:
>A = *[2,3,1,1,4]*, return true.

>A = *[3,2,1,0,4]*, return false.

# 中文描述
从数组的第一个元素开始，该元素的数字大小代表你能够跳跃的最大距离，求出给定数组能够跳跃到最后的元素
这是一道简单的动态规划的题目。遍历每一个元素，保留局部最优解。最后将局部最优解转化为全局最优解。

## 代码示例

``` java
public boolean canJump(int[] nums) {
    if(nums==null||nums.length<1){
        return false;
    }
    int end  =0;
    for (int i = 0; i <= end&&i<nums.length; i++) {
            end = Math.max(i+nums[i],end);
    }
    if(end!=nums.length-1){
        return false;
    }
    return true;
}
```
LeetCode学习持续更新，Gtihub链接
https://github.com/yanqinghe/leetcode
