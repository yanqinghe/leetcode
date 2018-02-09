# LeetCode78 SubSets

## 问题描述

> Given a set of distinct integers, nums, return all possible subsets.

>Note: The solution set must not contain duplicate subsets.

>For example,
If nums = [1,2,3], a solution is:

```
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

```

## 简单分析

这道题和上一道题[LeetCode77 Combinations](http://blog.csdn.net/yanqinghe123/article/details/78196259)很相似，这道题是求一个集合的子集，其实也就是一些组合加上其他的集合。
那么怎么修改前面的代码就可以实现呢。

很简单，在进入下一层递归的时候，就把当前的集合添加到结果集中。
比如
[1,2,3]以1开始的子集。

**[]
[1]
[1,2]
[1,2,3]**

思路就是上面的思路，下面看代码。。

## 代码入下

``` java

public List<List<Integer>> subsets(int[] nums) {
    result.add(new ArrayList<>());
    if(nums==null||nums.length<1){
        return  result;
    }
    help(new ArrayList<>(),0,0,nums);
    return result;
}
List<List<Integer>> result = new ArrayList<>();
private void help(List<Integer> list,int from,int l,int[] nums){
    if(l==nums.length){
        return;
    }else {

        for (int i = from; i < nums.length; i++) {
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
