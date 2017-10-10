#LeetCode77 Combinations

## 问题描述

>Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

>For example,
>If n = 4 and k = 2, a solution is:

```

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

```

## 简单分析

这道题和之前的一些求排列的题目不同，是求组合。不过组合和排列很相似，只不过是用过的元素不在使用罢了。

之前在全排列的时候采用的是回溯的方法，这里也是使用回溯的方法，不过在对添加i元素以后，就舍去i之前的那些元素了，因为那些之前的元素会造成重复

## 代码如下
``` java 

List<List<Integer>> result = new LinkedList<>();

public List<List<Integer>> combine(int n, int k) {
    if(n==0||k==0){
        return result;
    }
    help(new LinkedList<>(),1,0,k,n);
    return result;
}

private void help(List<Integer> list ,int from,int l,int k,int n){
    if(l==k){
        //如果到了最后一层
        result.add(new LinkedList<>(list));
    }else {
        for (int i = from; i <= n; i++) {
            list.add(i);
            help(list,i+1,l+1,k,n);
            list.remove(list.size()-1);
        }
    }
}

```
LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
