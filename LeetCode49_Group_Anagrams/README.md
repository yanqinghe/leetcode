#Group Anagrams

# 问题描述 

>Given an array of strings, group anagrams together.

>For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
>Return:
```
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```
> Note: All inputs will be in lower-case. 

## 简单分析

这道题目的意思就是从把有相同字符的字符串分类到一起。

因为字符串的顺序是被打乱的，所以基本思路就是先对字符串进行字典排序，得到新的字符串。利用HashMap的特点，构造一个由字符串和对应List index的Map。

如果Map key包含当前字符串，那么取出index 然后List.get(index) 得到对应的List。把新的字符串添加进去

如果不包含当前字符串，那么新建一个list，把字符串添加进去，然后把对应的index和字符串作为键值对存到Map中


以上就是两种情况。下面看具体的代码。

##  代码

``` java
 public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String,Integer> map = new HashMap();
    for(int i =0;i<strs.length;i++){
        char[] temp = strs[i].toCharArray();
        Arrays.sort(temp);
        String str = String.valueOf(temp);
        if(map.containsKey(str)){
            result.get(map.get(str)).add(strs[i]);
        }else{
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            map.put(str,result.size());
            result.add(list);


        }
    }
    return result;
}

```

LeetCode学习笔记持续更新，

GitHub地址https://github.com/yanqinghe/leetcode
