# Multiply Strings

## 问题描述

>Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

>**Note:

>The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
**

## 中文简介

这道题就是把两个字符串代表的整数进行乘法运算，可以说是大数乘法（因为int或者long能代表的数还是有限的），之前写过一个，采用模拟乘法计算的竖式的形式。这次从网上发现了另外一种算法。

对于乘法计算，可以根据规律得到相应的算法。分别计算结果的每一位，把这些单独的位连接起来就是最后的计算结果了。那么怎么计算每一位呢。

比如1234*12 

第一位就是*4\*2*

第二位就是*4\*1+3\*2*

第三位就是*3\*1+2\*2*

第四位就是*2\*1+1\*2*

第五位就是*1\*1+0\*2*


可以看出关系是相关位附近的数对应积之和

根绝以上信可以写出具体的代码

``` java
public class Solution43 {
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        System.out.println("args = [" + solution43.multiply("1111","222222") + "]");
    }
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null){
            return null;
        }
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
            return "0";
        }
        StringBuilder stringBuilder= new StringBuilder();
        int num = 0;
        for(int i = num1.length()+num2.length()-1;i>=0;i--){
            //对应位附近的数字范围
            for(int j = Math.min(num1.length(),i)-1;j>=0;j--){
                //如果超过了范围，跳过
                if(i-j<=num2.length()){
                    num+=(num1.charAt(j)-'0')*(num2.charAt(i-j-1)-'0');
                }
            }
            if(i!=0 || num>0)
                stringBuilder.append(num%10);
            num = num/10;
        }
        //需要转换String的顺序。
        return stringBuilder.reverse().toString();
    }

}
```

LeetCode学习笔记Gtihub，持续更新

https://github.com/yanqinghe/leetcode
