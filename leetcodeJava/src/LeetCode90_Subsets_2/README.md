# LeetCode90 Subsets II

> 问题来源[LeetCode90](https://leetcode.com/problems/subsets-ii/description/)

## 问题描述

>Given a collection of integers that might contain duplicates, nums, return all possible subsets.

>Note: The solution set must not contain duplicate subsets.

>For example,
If nums = [1,2,2], a solution is:
>
```
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

## 问题分析

这道题是[LeetCode78 SubSets](http://blog.csdn.net/yanqinghe123/article/details/78196322)的延续，不过是多了一个有重复元素。一般对于有重复的元素的问题，可以考虑对数组进行排序，然后跳过重复的元素，这道题可以很简单的用这种方式进行解决。

## 代码如下

```java

public List<List<Integer>> subsetsWithDup(int[] nums) {
    result.add(new ArrayList<>());
    if(nums==null||nums.length<1){
        return  result;
    }
    //对数组进行排序
    Arrays.sort(nums);
    help(new ArrayList<>(),0,0,nums);
    return result;
}
List<List<Integer>> result = new ArrayList<>();
private void help(List<Integer> list,int from,int l,int[] nums){
    if(l==nums.length){
        return;
    }else {
        for (int i = from; i < nums.length; i++) {
            if(i>from && nums[i]==nums[i-1]){
                //重复的元素，跳过
                continue;
            }
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            help(list,i+1,l+1,nums);
            list.remove(list.size()-1);
        }
    }
}
```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678

