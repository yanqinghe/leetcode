# LeetCode83 Remove Duplicates from Sorted List

[问题链接 LeetCode83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/)

## 问题描述

>Given a sorted linked list, delete all duplicates such that each element appear only once.

>For example,

>Given **1->1->2**, return **1->2** .

>Given **1->1->2->3->3**, return **1->2->3**. 

## 简单分析

这道题目就是简单的把重复的多余的元素都删除掉，因为链表本身是已经排序好的，所以不需要在进行排序了。只需要进行删除操作就可以了。

## 代码如下

``` java

public ListNode deleteDuplicates(ListNode head) {
    if(head==null){
        return head;
    }            
    ListNode myHead = new ListNode(-1);
    myHead.next = head;
    while(head.next!=null){
        if(head.val==head.next.val){
            head.next = head.next.next;
        }else{              
            head = head.next;
        }
    }    
    return myHead.next;
}
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }
```
LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678

