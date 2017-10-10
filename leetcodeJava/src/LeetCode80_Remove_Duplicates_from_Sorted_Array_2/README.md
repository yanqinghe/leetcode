# LeetCode81 Remove Duplicates from Sorted Array II

## 问题描述

>> Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

>Would this affect the run-time complexity? How and why?
>Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

>(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

>Write a function to determine if a given target is in the array.

>The array may contain duplicates.

## 问题分析

这道题就是一个去重的问题，没有什么难的。维护一个变量进行统计，大于2次以后不统计，然后把后面的元素放到前面来就可以了。

## 代码如下

``` java
public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length<1){
            return 0;
        }
    int d =1;
    int result =1;
    for(int i =1;i<nums.length;i++){
        if(nums[i]!=nums[i-1]){
            //如果不是重复的
            d=1;
            nums[result]=nums[i];
            result++;
        }else {
            //如果是重复的
            if(d<2){
                d++;
                nums[result]=nums[i];
                result++;
            }
        }
    }
    return result;
}
```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
