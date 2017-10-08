# LeetCode71 Simplify Path

## 问题描述

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = **"/home/"**, =>**"/home"**

path = **"/a/./b/../../c/"**, => **"/c"**

## 简单分析

这道题就是简化路径，看到这个路径我就想到了坑爹的windows系列路径分割符是'\'。这道题明显就是Unix的啦（哈哈）。这道题我的思路是先利用分割符进行分割，然后维护一个list，如果进入下一层路径，那么list添加，如果退到上一层路径，list删除最后一个元素。

## 代码如下

``` java

public String simplifyPath(String path) {
    StringBuilder stringBuilder = new StringBuilder();
    String[] strings = path.split("/");
    List<String> list = new LinkedList<>();
    for (String str:strings
            ) {
        if(str.equals("")||str.equals(".")){
            continue;
        }
        if(str.equals("..")){
            if(!list.isEmpty()){
                //如果list不为空，那么移除栈顶元素
                list.remove(list.size()-1);
            }
            continue;
        }
        list.add(str);
    }
    //根目录
    stringBuilder.append('/');
    for (String str: list
            ) {
        stringBuilder.append(str+'/');
    }
    if(stringBuilder.length()>1){
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }
    return stringBuilder.toString();
}

```

LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
