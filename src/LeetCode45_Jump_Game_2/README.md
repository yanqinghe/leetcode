# Jump Game II
## 问题描述

> Given an array of non-negative integers, you are initially positioned at the first index of the array.

>Each element in the array represents your maximum jump length at that position.

>Your goal is to reach the last index in the minimum number of jumps.

>For example:
Given array A = [2,3,1,1,4]

>The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

>Note:
You can assume that you can always reach the last index.

## 简单介绍

这道题与LeetCode55 Jump的题目基本类似，这道题是求最短的跳跃次数。
可以在迭代的过程中加入一个preEnd变量，如果当前次数下对应元素的跳跃后的位置超过了之前保存的最大位置，那么可以舍去上次保存的值。

具体代码如下
## 代码

```  java
public class Solution45 {
    public int jump(int[] nums) {
        int end = 0;
        int result=0;
        int preEnd =0;
        for(int i=0;i<=end&&i<nums.length;i++){
            if(i>preEnd){
                result++;
                preEnd = end;
            }
            end = Math.max(end,nums[i]+i);
        }
        if(end<nums.length-1){
            return 0;
        }
        return result;
    }
}
```

LeetCode学习笔记，持续更新Github

https://github.com/yanqinghe/leetcode