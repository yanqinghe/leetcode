#LeetCode87 Scramble String

## 问题来源[LeetCode87](https://leetcode.com/problems/scramble-string/description/)

## 问题描述
>Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

>Below is one possible representation of s1 = "great":

>    great
>   /    \
>  gr    eat
> / \    /  \
>g   r  e   at
>           / \
>          a   t
>To scramble the string, we may choose any non-leaf node and swap its two children.

>For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

>    rgeat
>   /    \
>  rg    eat
> / \    /  \
>r   g  e   at
>           / \
>          a   t
>We say that "rgeat" is a scrambled string of "great".

>Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

>    rgtae
>   /    \
>  rg    tae
> / \    /  \
>r   g  ta  e
>       / \
>      t   a
>We say that "rgtae" is a scrambled string of "great".

>Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

##问题分析

这道题说了一种爬行字符串，就是说假如把一个字符串当做一个二叉树的根，然后它的非空子字符串是它的子节点，然后交换某个子字符串的两个子节点，重新爬行回去形成一个新的字符串，这个新字符串和原来的字符串互为爬行字符串。

这里比较关键的就是节点内的字符串交换。看到题目给的树状模型，可以考虑采用分割法进行解决。

把*s1*和*s2*从*i*部分切割开来

1. 判断*s1*的左边与*s2*的左边和*s1*的右边与*s2*的右边是否互为爬行字符串，
2. 或者*s1*的左边与*s2*的右边和*s1*的右边与*s2*的左边是否为爬行字符串。

## 代码如下

``` java
public boolean isScramble(String s1, String s2) {
    if(s1.length()!=s2.length())
        //如果长度不相同，直接返回false
        return false;
    if(s1.equals(s2))
        //如果相等，直接返回true
        return true;
    //字符串转化为字符数组
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    //进行字典排序
    Arrays.sort(c1);
    Arrays.sort(c2);
    //如果字典排序后不想等，返回false
    if(!Arrays.equals(c1,c2))
        return false;
    for (int i = 1; i < s1.length(); i++) {
        if(isScramble(s1.substring(0,i),s2.substring(0,i))
                && isScramble(s1.substring(i),s2.substring(i)))
            return true;
        if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i))
                && isScramble(s1.substring(i),s2.substring(0,s2.length()-i)))
            return true;
    }
    return false;
}
```

## 问题分析2

以上算法的时间复杂度已经超过了多项式的复杂度，一般对于递归算法，都可以使用动态规划的方法来解决，那么这道题应该如何解决呢。

借鉴之前字符串的题目采用二维数组 *dp[][]* 来保存显然是不够的，在上面的算法中看到每次递归都需要对字符串扫描一遍，那么可以考虑使用**三维数组** *dp[][][]* 来保存数据。（灵感来源于http://blog.csdn.net/linhuanmars/article/details/24506703，感谢大佬）

其中 *dp[j][k][i]* 代表的是*i*,*j*,*k*代表的是字符串s1的从*j*位置开始，字符串s2从*k*开始，长度为*i*的部分是否互为爬行字符串。

那么动态规划的迭代公式应该是

***dp[j][k][i]|=dp[j][k][l]&&dp[j+l][k+l][i-l] ||dp[j][k+i-l][l]&&dp[j+l][k][i-l];***

这里采用 **"|="** 是因为对于所有i-1种劈法的结果求或运算，只要有一种满足即可。

动态规划的时间复杂度为 ***O(n^4)*** 空间复杂度为 ***O(n^3)***， 虽然比之前的很多题目都要耗时间，但是也算是不错的了。

## 代码如下

``` java

public boolean isScramble2(String s1,String s2){
    if(s1.length()!=s2.length())
        return false;
    if(s1.equals(s2))
        return true;
    int length = s1.length();
    boolean[][][] dp = new boolean[length][length][length+1];
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            dp[i][j][1]= s1.charAt(i)==s2.charAt(j);
        }
    }
    for(int i=2;i<=length;i++){
        for (int j = 0; j < length-i+1; j++) {
            for (int k = 0; k < length-i+1; k++) {
                for (int l = 1; l < i; l++) {
                    dp[j][k][i]|=dp[j][k][l]&&dp[j+l][k+l][i-l] ||dp[j][k+i-l][l]&&dp[j+l][k][i-l];
                }

            }
        }
    }

    return dp[0][0][length];
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678

