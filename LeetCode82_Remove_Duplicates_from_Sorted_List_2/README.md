# LeetCode82 Remove Duplicates from Sorted List II

## 问题来源[LeetCode82](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/)

## 问题描述
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given **1->2->3->3->4->4->5**, return **1->2->5**.
Given **1->1->1->2->3**, return **2->3**.

## 问题分析

这道题和[LeetCode83](http://blog.csdn.net/yanqinghe123/article/details/78244133)是类似的，只不过这道题是把重复的那个元素删除，83是只删除掉多余的部分。
代码结构也是基本相同的，不过这道题需要注意把元素全部删除。

##代码如下

``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public ListNode deleteDuplicates(ListNode head) {    
    if(head==null){
        return head;
    } 
    ListNode myHead = new ListNode(-10000);
    myHead.next=head;
    int v = myHead.val;
    ListNode headLast = myHead;
    while(head.next!=null){
        if(head.val==head.next.val || head.val == v){
            //如果存在重复，那么
            v  =head.val;
            headLast.next =head.next;
            head = head.next;
        }else{
            //不过不重复
            headLast = head;
            head = head.next;
        }
    }
    if(head.val ==v){
        headLast.next = head.next;
    }
    return myHead.next;
}
```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
