# Insert Interval

## 问题描述

>> Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals ``` [1,3],[6,9] ```, insert and merge ``` [2,5] ``` in as  ``` [1,5],[6,9] ```.

Example 2:
Given ``` [1,2],[3,5],[6,7],[8,10],[12,16] ```, insert and merge ```[4,9]``` in as ``` [1,2],[3,10],[12,16] ```.

This is because the new interval ``` [4,9]``` overlaps with ``` [3,5],[6,7],[8,10]```.

## 简单分析

这道题和LeetCode56 Merge Intervals题目是类似的，只不过这道题给定的区间是已经排序过的，这样的话就可以直接利用上一道题的思想进行解决了。

对于一个待插入的区间，要考虑以下问题.

1. 该区间与其他区间是否重叠
2. 如果不重叠的话，应该插入到哪里
3. 如果重叠的话，到底与哪些区存在重叠

根据问题我们就可以进行一下操作,从第一个区间开始遍历，
1. 如果待插入区间的结尾大于当前区间的开始，那么说明带插入区间和当前区间没有重叠，直接将带插入区间放入结果集中，然后将当前区间也放入结果集中。
2. 如果存在重叠的部分，那么就把带插入区间的左右边界分别扩张为俩个区间合并后的边界。然后与下一个区间进行对比。
3. 在以上操作的过程中不要忘记如果区间完成插入以后后面的不需要进行对比，这里我就维护了一个boolean的变量。

## 代码如下

``` java
public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new LinkedList<>();
    if(intervals==null||intervals.size()<1){
        result.add(newInterval);
        return result;
    }
    if(newInterval==null){
        return intervals;
    }
        boolean b= false;
    for(int i =0;i<intervals.size();i++){
        if((!b)&&newInterval.start<=intervals.get(i).end){
            if(newInterval.end<intervals.get(i).start){
                //不存在重叠的部分
                result.add(newInterval);
                b =true;
            }else {
                newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
                newInterval.start= Math.min(newInterval.start,intervals.get(i).start);
                continue;
            }
        }
        result.add(intervals.get(i));
    }
    if(!b){
        result.add(newInterval);
    }
    return result;
}

```

LeetCode学习笔记持续更新GitHub地址
https://github.com/yanqinghe/leetcode

CSDN博客地址
http://blog.csdn.net/yanqinghe123/article/category/7176678