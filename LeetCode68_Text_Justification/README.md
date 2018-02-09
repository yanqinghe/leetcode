# LeetCode68 Text Justification

## 问题描述

> Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

> You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

>Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

>For the last line of text, it should be left justified and no extra space is inserted between words.

>For example,
words: ```["This", "is", "an", "example", "of", "text", "justification."]```
L: ```16.```

Return the formatted lines as:
```
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```
## 简单分析

看到这道题的标签是hard感觉就不会很容易，但是看到题目以后觉着还是比较容易想到解决方案的。这道题目标是调整字符串的显示格式，之前在做Android的时候出现的一个问题就是text控件容易出现的问题如果当前行的宽度无法容下一个字符串，那么在这一行会空出一大部分的，大概是因为空格都填充在这里了，这道题的目标就是把空格尽量均匀的分散开来。
所以，这道题比较复杂的地方是如何把空格分散放置，至于判断当前哪一行有哪些字符串就比较简单了。

我采取的方案是首先计算改行字符串的总长度和字符串的个数，如果当前字符串超过了范围，那么对上一行进行排布。

组织的方式是计算总空格个数

计算每个字符串后面跟的空格个数（每一行最后一个字符串后面没有空格，最后一行除外）

最后一行的情况与上面还不太相同。为了更容易分辨出来是最后一行，最后一行采取的是左对齐，也就是最后一行的字符串之间只有一个空格。结束后后面补充空格。

## 代码如下

```java

  public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        if(words==null||words.length<1 ){
            return result;
        }
        int start = 0;
        int num=1;//元素的个数
        int sum = words[0].length();//元素累加的长度，包括空格
        for (int i = 1; i < words.length; i++) {
            if (sum + num+words[i].length() > maxWidth ) {
                //如果加上当前元素越界的话，或者是到最后一个元素的话
                StringBuilder sb =new StringBuilder();
                if(num==1){
                    //如果只包含一个元素。
                    int blank =maxWidth-sum;
                    sb.append(words[start]);
                    for (int j = 0; j < blank; j++) {
                        sb.append(' ');
                    }
                }else {
                    //包含多个元素
                    //获取空格的个数
                    int blank = maxWidth-sum;
                    //获取元素的个数
                    //多余的空格数
                    int blankHelp = blank%(num-1);
                    blank /=(num-1);
                    //形成空格数组
                    int[] n = new int[num];
                    for (int j = 0; j < num-1; j++) {
                        if(blankHelp-- >0){
                            n[j]=blank+1;
                        }else {
                            n[j]=blank;
                        }
                    }
                    n[num-1]=0;
                    for (int j = start; j < i; j++) {
                        sb.append(words[j]);
                        for (int k = 0; k < n[j-start]; k++) {
                            sb.append(' ');
                        }
                    }
                }
                result.add(sb.toString());
                sum =words[i].length();//长度
                start=i;//重置起始位置
                num=1;//清空个数

            }else {
                //如果不越界的话
                sum=sum+words[i].length();
                num++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(sum+num-1<=maxWidth){

            for (int i = start; i < words.length-1; i++) {
                sb.append(words[i]);
                sb.append(' ');
            }
            sb.append(words[words.length-1]);
            for(int i=sum+num-1;i<maxWidth;i++){
                sb.append(' ');
            }
        }
        result.add(sb.toString());
        return result;
    }

```


LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
