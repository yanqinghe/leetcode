#LeetCode89 Gray Code

> 问题来源[LeetCode89](https://leetcode.com/problems/gray-code/description/)

## 问题描述

>Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

>For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
```
00 - 0
01 - 1
11 - 3
10 - 2

```
>Note:
For a given n, a gray code sequence is not uniquely defined.

>For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

>For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

## 问题分析

Gray Code（格雷码）具体的用途可以看一下百度百科。一般格雷码有专门的迭代公式。

n位格格雷码=

最高位0 + n-1位格雷码的顺序 +

最高位1 + n-1位格雷码的逆序。

最高位0不影响大小，最高位1可以通过位运算来实现。**1 << (n-1)**

## 代码如下


``` java

public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
    result.add(0);
    if(n==0){
        return result;
    }
    List<Integer> tmp = grayCode(n-1);
    int addNumber = 1 << (n-1);
    result = new ArrayList<Integer>(tmp);
    for(int i=tmp.size()-1;i>=0;i--) {
        result.add(addNumber + tmp.get(i));
    }
    return result;
}
```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
