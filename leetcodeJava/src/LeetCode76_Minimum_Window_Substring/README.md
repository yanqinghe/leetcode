#LeetCode76 Minimum Window Substring

## 问题描述

>Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

>For example,
S = **"ADOBECODEBANC"**
T = **"ABC"**
Minimum window is "BANC".

>Note:
>If there is no such window in S that covers all characters in T, return the empty string "".

>If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

## 问题分析

这道题题目的含义就给出了一些解题的思路，如何获取这个窗？可以考虑维护一个动态的窗，从左到右遍历字符串S，最后返回最小的结果。

那么这个窗应该怎么操作呢，首先能够想到这个窗户的长度是可以变化的，但是必须大于或等于T字符串的长度。

这个窗户的变化可以利用左右游标的变化来进行伸缩和移动，首先移动右游标。

如果窗户的宽度符合T字符串的要求，那么进行判断，

如果不满足，那么继续移动右游标，

如果满足条件，那么记录当前大小，然后移动左游标。

然后再一次进行判断，决定移动左游标还是右游标，最后右游标移动到最后。完成遍历。

## 代码如下

``` java
public String minWindow(String s, String t) {
    if(s==null||s.length()<1){
        return "";
    }
    Map<Character,Integer> tMap = new HashMap<>();
    //将t字符串中的字符保存到Map中
    for (int i = 0; i < t.length() ; i++) {
        if(tMap.containsKey(t.charAt(i))){
            //如果已存在，累加
            tMap.put(t.charAt(i),tMap.get(t.charAt(i))+1);
        }else {
            //如果不存在,添加
            tMap.put(t.charAt(i),1);
        #  }
    }

    int left = 0;//最小字符串对应t字符串的左边位置
    int right = s.length();//最小字符串对应s字符串的右边位置
    int count =0; //当前窗口的大小
    for(int r=0,l=0;r<s.length();r++){
        if(tMap.containsKey(s.charAt(r))){
            tMap.put(s.charAt(r),tMap.get(s.charAt(r))-1);
            if(tMap.get(s.charAt(r))>=0){
                count++;
            }
            while(count==t.length()){
                //if size of window == s.length()
                if(r-l<=right-left){
                    left=l;
                    right=r;
                }
                if(tMap.containsKey(s.charAt(l))){
                    tMap.put(s.charAt(l),tMap.get(s.charAt(l))+1);
                    if(tMap.get(s.charAt(l))>0){
                        count--;
                    }
                }
                l++;
            }
        }

    }
    if(right-left+1>s.length()){
        return "";
    }
    return s.substring(left,right+1);
}
```


LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
