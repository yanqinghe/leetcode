# Add Two Numbers

## 问题描述

_You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list._

_You may assume the two numbers do not contain any leading zero, except the number 0 itself._

_Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)_

_Output: 7 -> 0 -> 8_

## 中文解释

题目给定两个非空的链表，分别代表非负整，数字以相反的顺序存储，每个节点包含一个数字。求两个数字的和，返回相应的链表。

针对这道题目，可以理解为链表代表的是数字的每一位数，两个链表分别代表m和n位数，将这两个数进行相加。
比如342+465=807,当然链表的头代表的是个位数。
可以考虑维护两个ListNode对象，然后进行循环求和，当发现某一个ListNode对象为空的时候，说明该ListNode对应的链表元素已经遍历完，便退出循环，将另外一个链表的其它元素进行追加。如果上一位有进1行为，需要考虑进去。
下面是完整的实现代码。

```java
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currentl1 = l1;
    ListNode currentl2 = l2;
    ListNode result = new ListNode(0);
    ListNode resultNext = result;
    ListNode kongNode = new ListNode(0);
    int op = 0;
    while (currentl1!=kongNode || currentl2!=kongNode) {
        int opResult = currentl1.val + currentl2.val + op;
        if (opResult >= 10) {
            result.next = new ListNode(opResult - 10);
            op = 1;
        } else {
            result.next = new ListNode(opResult);
            op = 0;
        }
        currentl1 = currentl1.next == null ? kongNode : currentl1.next;
        currentl2 = currentl2.next == null ? kongNode : currentl2.next;
        result = result.next;
    }
    if(op==1){
        result.next=new ListNode(1);
    }
    return resultNext.next;
}

```

>GitHub链接https://github.com/yanqinghe/leetcode/tree/master/leetcodeJava/src/Add_2_Numbers_2