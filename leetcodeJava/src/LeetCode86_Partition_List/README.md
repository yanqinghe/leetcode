#LeetCode86 Partition List

## 问题来源[LeetCode86](https://leetcode.com/problems/partition-list/description/)

## 问题描述

>Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

>You should preserve the original relative order of the nodes in each of the two partitions.

>For example,
Given **1->4->3->2->5->2** and **x = 3**,
return **1->2->2->4->3->5**.

## 问题分析

这道题就是链表的简单操作，思路就是初始化两个node，把大于x的放置到一个node下，小于等于x的放置到另外一个node下，最后把两个node连接起来。

需要注意的是在挂接到node下的时候，需要把当前node的next置为null，不会然导致超出空间大小。
## 代码如下

```java
/**
    * Definition for singly-linked list.
    * public class ListNode {
    * int val;
    * ListNode next;
    * ListNode(int x) { val = x; }
    * }
    */
public ListNode partition(ListNode head, int x) {
    if(head==null)
        return head;
    ListNode myhead = new ListNode(0);
    ListNode left= new ListNode(0);
    myhead.next = left;
    ListNode right = new ListNode(0);
    ListNode midHead = new ListNode(0);
    midHead.next = right;
    while(head!=null){
        ListNode node = head.next;
        if(head.val<x){
            left.next = head;
            left = left.next;
            left.next = null;
        }else {
            right.next = head;
            right = right.next;
            right.next = null;
        }
        head= node;
    }
    left.next = midHead.next.next;
    return myhead.next.next;
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678


