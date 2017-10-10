#LeetCode81 Search in Rotated Sorted Array II

## 问题描述

>Follow up for "Search in Rotated Sorted Array":
>What if duplicates are allowed?

>Would this affect the run-time complexity? How and why?
>Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

>(i.e., **0 1 2 4 5 6 7** might become **4 5 6 7 0 1 2**).

>Write a function to determine if a given target is in the array.

>The array may contain duplicates.

## 简单分析

这道题是之前的题目[LeetCode33]()的延伸，都是在一个旋转后的数组中用二分法进行查找，不过这道题多了一个条件，那就是数组**有可能包含重复元素**。

包含重复元素就意味着在判旋转的那个节点位置的时候存在问题。例如 **[1,2,4,4,4,4,4]** 在旋转后变成 **[4,4,4,1,2,4]** 。 无法简单的通过判断mid和left的大小来确定旋转节点的位置。因为left 和right都等于mid。所以对于这种情况，需要移动边界，直到明确的确认 *left*、 *mid* 和 *right* 的关系。

## 代码如下

``` java
public boolean search(int[] nums, int target) {
        if(nums==null || nums.length<1) 
        return false;
    //初始化左右游标 
    int left =0;
    int right = nums.length -1;
    while(left<=right){
        int mid =(left+right)/2;
        if(nums[mid]==target){
            //找到目标值返回true
            return true;
        }               
        if(nums[mid]>nums[left]){
            if(nums[mid]>target&&nums[left]<=target){       
                right = mid-1;
            }else{
                left = mid+1;
            }
        }else if(nums[mid]<nums[left]){
                if(nums[mid]<target&&nums[right]>=target){
                left = mid+1;
            }else{
                right= mid -1;
            }
        }else{
            left++;
        }
    }
    return false;
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
