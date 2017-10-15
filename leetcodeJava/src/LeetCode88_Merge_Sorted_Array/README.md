#LeetCode88 Merge Sorted Array

> 问题来源[LeetCode88](https://leetcode.com/problems/merge-sorted-array/description/)

## 问题描述

>Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

>Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

## 问题分析

这道题比较简单，两个已经排序好的数组，直接对比然后进行插入排序就好。

## 代码如下

``` java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int all = m+n-1;
    m--;
    n--;
    while (m>=0||n>=0){
        if(n<0||(m>=0&&nums1[m]>=nums2[n])){
            nums1[all]=nums1[m];
            m--;
            all--;
            continue;
        }
        if(m<0||(n>=0&&nums1[m]<nums2[n])){
            nums1[all]=nums2[n];
            n--;
            all--;
            continue;
        }
    }
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
