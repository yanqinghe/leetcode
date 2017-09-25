# Permutations

## 问题描述

>Given a collection of distinct numbers, return all possible permutations.

>For example,
[1,2,3] have the following permutations:


```
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```

## 简单介绍

这道题就是求排列组合问题中的排列问题，在前面LeetCode31 Next Permutation 这道题目中是求下一个排列数。可能会联想这两道题有什么关系，但是实际上解法没有关系。在这道题目中采用动态规划的做法就可以解决问题，简单来说把这些数字组成所有的排列。

采用动态规划的话需要维护一个数组**dp[i]**代表的是数组中的第i个数字有没有被使用。
具体代码如下

## 代码

``` java
public void help(List<Integer> temp,int[] nums,boolean[] dp){
    if(temp.size()==nums.length){
        List<Integer> a = new ArrayList<>(temp);
        result.add(a);
    }else {
        for(int i =0;i<nums.length;i++){
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

LeetCode学习笔记持续更新，GitHub地址

https://github.com/yanqinghe/leetcode
