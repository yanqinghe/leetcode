# LeetCode75 Sort Colors

## 问题描述

> Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

>Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

>Note:
You are not suppose to use the library's sort function for this problem.

>click to show follow up.

>Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

>Could you come up with an one-pass algorithm using only constant space?

## 简单分析

这道题目的解决思路很多，但是题目在最后说到能够使用 *O(1)* 的时间，所以就需要利用原来的数组解决这个问题。因为只有三个类别，可以考虑对数组元素进行交换来实现整个的分类。具体的解决方案如下：
1. 遍历数组
2. 如果为0，就从头往后放，如果为2，就从后往前放。这样放置完成以后中间剩下的就是1.

PS：在这里需要考虑对数组不能完全遍历。不然会影响到已分类好的2元素。具体的算法如下。

## 代码如下

``` java
public void sortColors(int[] nums) {
    int rn =0,bn=0;//初始化红蓝的计数
    //上限是nums.length-bn 因为后面的bn个是已经归类好的蓝色球，所以不需要进行操作
    //如果继续进行操作会把归类好的打乱
    for (int i = 0; i < nums.length-bn; i++) {
        if(nums[i]==0){
            //如果是红色
            swap(nums,i,rn);
            rn++;
        }else if(nums[i]==2){
            swap(nums,i,nums.length-1-bn);
            bn++;
            i--;
        }
    }
}
private void swap(int[] nums,int a,int b){
    int temp = nums[a];
    nums[a]=nums[b];
    nums[b]=temp;
}
```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
