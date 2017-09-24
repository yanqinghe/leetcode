# Trapping Rain Water

## 问题描述

>Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

>For example, 
Given **[0,1,0,2,1,0,1,3,2,1,2,1]**, return 6.

![img](http://www.leetcode.com/static/images/problemset/rainwatertrap.png)

>The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

## 中文介绍

看到这道题，觉着很有意思，看一下图的话会很容易理解这道题在讲什么，就是给定的数组代表的是高低不同的柱子，如果下雨以后最多能保存多少水。就我个人而言，如果从左到右计算的话，需要保存左边的高度，如果出现了一个凹陷处，就把计算这部分保存的水量，然后丢掉没用的数据。这里面有一个先后的问题，所以就考虑采用stack进行保存。

然后具体看一下保存的过程。（以题目给定的数据为例子）
最上面一行代表的是数组元素，下面的代表的是stack中保存的数据，靠近标题栏的一行为栈底。

| 0   | 1   | 0   | 2   | 1   | 0   | 1   | 3   | 2   | 1   | 2   | 1   |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| *0* | *1* | 1   | *2* | 2   | 2   | 2   | *3* | 3   | 3   | 3   | 3   |
|     |     | *0* |     | *1* | 1   | *1* |     | *2* | 2   | *2* | 2   |
|     |     |     |     |     | *0* |     |     |     | *1* |     | *1* |

上面的斜体代表的是新添加的元素。

因为另外需要计算水量，也就是高度对应的数组位置，就另外增加了一个stack来保存对应的index。

## 对应代码

``` java
class Solution42 {
    public static void main(String[] args){
        Solution42 solution42 = new Solution42();
        int[] a = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        System.out.println(solution42.trap(a));
    }
    public int trap(int[] height) {        
        int result =0;
        Stack<Integer> stack2 = new Stack();
        Stack<Integer> stack = new Stack();

        for(int i=0;i<height.length;i++){
            if(stack.isEmpty()||height[i]<stack.peek()){
                stack.add(height[i]);
                stack2.add(i);
            }else {
                int preH =0;
                int r =0;
                while(!stack.isEmpty()&&height[i]>=stack.peek()){
                    int h = stack.pop();
                    r += (h-preH)*(i-stack2.pop()-1);
                    preH = h;
                }
                if(!stack.isEmpty()&&height[i]>preH){
                     r+=(height[i]-preH)*(i-stack2.peek()-1);
                }
                stack.add(height[i]);
                stack2.add(i);
                result+=r;
            }
        }
        return result;
    }
}

```
## 其他解法
采用上面的算法虽然通过了测试，但是排名只在后百分之10；然后就看了一下其他人的解法。
参考的页面
https://leetcode.com/problems/trapping-rain-water/solution/
### Brute force [Accepted] 暴力破解

>Algorithm
暴力破解的思想就是从左边开始遍历，然后寻找元素左右两边的最大值
然后用左右两边高度最大值的较小者减去当前的高度，
把这些高度累加起来，就是最后的结果。

官网提供的代码

c++
``` c++
int trap(vector<int>& height)
{
    int ans = 0;
    int size = height.size();
    for (int i = 1; i < size - 1; i++) {
        int max_left = 0, max_right = 0;
        for (int j = i; j >= 0; j--) { //Search the left part for max bar size
            max_left = max(max_left, height[j]);
        }
        for (int j = i; j < size; j++) { //Search the right part for max bar size
            max_right = max(max_right, height[j]);
        }
        ans += min(max_left, max_right) - height[i];
    }
    return ans;
}
```
## 动态规划
所谓的动态规划就是提前把元素对应的左右两边的元素储存起来，然后通过一次遍历即可得到最后的结果。具体代码参见下面。

c++
``` c++
int trap(vector<int>& height)
{
    if(height == null)
        return 0;
    int ans = 0;
    int size = height.size();
    vector<int> left_max(size), right_max(size);
    left_max[0] = height[0];
    for (int i = 1; i < size; i++) {
        left_max[i] = max(height[i], left_max[i - 1]);
    }
    right_max[size - 1] = height[size - 1];
    for (int i = size - 2; i >= 0; i--) {
        right_max[i] = max(height[i], right_max[i + 1]);
    }
    for (int i = 1; i < size - 1; i++) {
        ans += min(left_max[i], right_max[i]) - height[i];
    }
    return ans;
}    
```
## 利用两个指针

这个算法是我觉着很有技巧的算法
具体的过程就是维护两个指针，分别从数组的最左边和最右边开始。向中间移动左右两边的指针，当右边指针对应的高度大于左边的指针的时候，计算高度差。然后移动左边的指针，当左边的指针大于右边的指针的时候计算高度差，然后移动右边的指针。就这样每次移动进行判断，计算高度差。最后到两个指针重合于一点。

这个算法LeetCode上有对应的短片，可以看到相应的过程，感觉这个是实现起来最优雅的方法了（向大佬低头。）

具体代码如下
c++

``` c++
int trap(vector<int>& height)
{
    int left = 0, right = height.size() - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
            ++left;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            --right;
        }
    }
    return ans;
}
```

持续更新LeetCode的学习过程，大家可以多翻翻这个博客或者去我的github

链接
https://github.com/yanqinghe/leetcode


