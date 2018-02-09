# Permutations II

## 问题描述

>Given a collection of numbers that might contain duplicates, return all possible unique permutations.
>For example,
>[1,1,2] have the following unique permutations:
```
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```

## 简单介绍

这道题也是排列问题，与[LeetCode46 permutations](http://blog.csdn.net/yanqinghe123/article/details/78087873)是类似的题目，但是这个题目有所不同的是有候选数组中有重复元素，要求在最后的结果中不能出现重复的组合形式。题目中的介绍也能看出这一点。

最简单的方法就是把上文中的结果List换成Set，这样就不会有重复的元素了，虽然能够过，但是效率十分的低下。既然这样，只能在添加元素的过程中跳过那么些元素了。
å
1. 首先对给定的数组进行排序，让重复的元素相邻在一起，
2. 然后在便利的过程中，如果当前元素与前一个元素是重复的，那么跳过该元素的递归。

这样就不会出现重复的元素了，具体的代码如下。

## 代码

``` java

public void help(List<Integer> temp,int[] nums,boolean[] dp){
    if(temp.size()==nums.length){
        List<Integer> a = new ArrayList<>(temp);
        resultList.add(a);
    }else {
        for(int i =0;i<nums.length;i++){
            if(i>0&& !dp[i-1]&& nums[i]==nums[i-1]){
                continue;
            }
            if(!dp[i]){
                temp.add(nums[i]);
                dp[i]=true;
                help(temp,nums,dp);
                temp.remove(temp.size()-1);
                dp[i]=false;
            }
        }
    }
}

```

LeetCode学习笔记持续更新。。

GitHub地址 https://github.com/yanqinghe/leetcode

