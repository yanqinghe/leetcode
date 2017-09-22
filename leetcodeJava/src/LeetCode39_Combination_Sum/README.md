# Combination Sum

## 问题描述

>Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

>The same repeated number may be chosen from C unlimited number of times.

>Note:
>1. All numbers (including target) will be positive integers.
>2. The solution set must not contain duplicate combinations.

>For example, given candidate set [2, 3, 6, 7] and target 7,

> A solution set is: 

>
```
[
  [7],
  [2, 2, 3]
]
```

看到这道题首先想到的是之前的求Target对应的K个数之和。但是这道题是没有限制解数字的个数和使用次数的。
采用回溯的方法能够解决此问题。

回溯算法在百度百科中的介绍为
> 回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。

在这道题中的体现就是从候选数组的第一个元素开始，将所有的情况进行枚举，如果当前List对应的和超过target，那么退出该分支（体现的操作就是恢复List），然后继续进行另外的分支。

代码如下：
``` java

public class Solution39 {
    // 定义结果list
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 首先对候选数组进行排序操作
        Arrays.sort(candidates);
        // 执行递归操作
        getList(new ArrayList(),candidates,0,target);
        return result;
    }
    public void getList(List<Integer> list,int[] candidates,int i,int target){
        if(target==0){
            // 如果target=0，也就是list满足和为目标值，那么新建一个List对象，
            List<Integer> arrayList = new ArrayList<Integer>(list);
            // 将新建的list对象添加到结果List中
            result.add(arrayList);
        }else{
            // 从当前i开始，枚举i后（包括i）的所有候选元素，（如果元素大于target值，那么直接终止）
            for(int j=i;j<candidates.length && candidates[j]<=target;j++){
                list.add(candidates[j]);
                // 继续进行递归
                getList(list,candidates,j,target-candidates[j]);
                // 在这里需要对list进行恢复操作。
                list.remove(list.size()-1);
            }
        }

    }
}

```

本题的Github地址。
https://github.com/yanqinghe/leetcode/tree/master/leetcodeJava/src/Combination_Sum_39