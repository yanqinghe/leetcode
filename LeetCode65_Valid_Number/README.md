# LeetCode65 Valid Number

## 问题描述

> Validate if a given string is numeric.

>Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

>Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

> https://leetcode.com/problems/valid-number/description/

## 简单分析

这道题算法上没有难的地方，主要是需要考虑的情况特别多。比如：
可以通过的条件
1. 只有数字和空格
2. 出现正负号，必须是第一位或者在e后面的第一位，后面要紧跟数字
3. 出现小数点， 前面不能有小数点出现或者e出现，小数点前面是数字（不能再第一位）和小数点后面是数字(不能在最后一位)
4. 出现e/E，前面不能出现过e/E，不能是第一位和最后一位

上面这些规矩看起来特别头疼，这道题在我做的时候（2017年10月8日）只有12%的通过率，果然深坑啊。
有了上面的判断条件就可以开始写了。

1. 首先把字符串前后多余的空格去掉。
2. 然后初始化三个状态判断，分别是对应小数点、正负号、eE的判断。
3. 因为要考虑正负号和e的位置，所以两者的状态变量是**int**类型，保存对应的位置。

下面是我从网上收集以及自己写的时候测试的一些算例子，大家可以参考一下。

``` java

   List<String> testdata = new LinkedList<>();
        testdata.add(".1");//True
        testdata.add("1.");//True
        testdata.add("0"); // True
        testdata.add(" 0.1 "); // True
        testdata.add("abc"); // False
        testdata.add("1 a"); // False
        testdata.add("2e10"); // True
        testdata.add("-e10"); // False
        testdata.add(" 2e-9 "); // True
        testdata.add("+e1"); // False
        testdata.add("1+e"); // False
        testdata.add(" "); // False
        testdata.add("e9"); // False
        testdata.add("4e+"); // False
        testdata.add(" -."); // False
        testdata.add("+.8"); // True
        testdata.add(" 005047e+6"); // True
        testdata.add(".e1"); // False
        testdata.add("3.e"); // False
        testdata.add("3.e1"); // True
        testdata.add("+1.e+5"); // True
        testdata.add(" -54.53061"); // True
        testdata.add(". 1"); // False

```

## 代码如下

``` java
    //可以通过的条件
    //1 只有数字和空格
    //2 出现正负号，必须是第一位或者在e后面的第一位，后面要紧跟数字
    //3 出现小数点， 前面不能有小数点出现或者e出现，小数点前面是数字（不能再第一位）和小数点后面是数字(不能在最后一位)
    //4 出现e/E，前面不能出现过e/E，不能是第一位和最后一位
    public boolean isNumber(String s) {
        if(s==null){
            return false;
        }
        s= s.trim();//去除前后的空格
        if(s.length()<1){
            return false;
        }
        boolean  dotExist  = false;//小数点判断
        int  pExist = -1;//正负号判断
        int  eExist =-1;//e判断
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                case '+':
                case '-':
                    //如果出现正负号
                    if(i!=0 && i!= eExist+1 || i==s.length()-1){
                        //如果重复出现或者不在第一位和e后面的一位
                        return false;
                    }
                    pExist=i;
                    break;
                case '.':
                    //如果出现小数点
                    if(dotExist||eExist!=-1||((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'))
                            && (i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9')))){
                        return false;
                    }
                    dotExist=true;
                    break;
                case 'e':
                case 'E':
                    //如果出现e
                    if(eExist!=-1||i==0||i==s.length()-1 ||pExist+1==i){
                        return false;
                    }
                    eExist=i;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
```



LeetCode学习笔记持续更新

GitHub地址 https://github.com/yanqinghe/leetcode

CSDN博客地址 http://blog.csdn.net/yanqinghe123/article/category/7176678
