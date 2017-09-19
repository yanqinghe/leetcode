# First Missing Positive

## 问题描述

> Given an unsorted integer array, find the first missing positive integer.

> For example,
> Given [1,2,0] return 3,
> and [3,4,-1,1] return 2.

> Your algorithm should run in O(n) time and uses constant space.

## 分析

这道题的意思就是从给出的**未排序**数组中找出第一个缺少的正整数。
该题关键的一句话就是要求时间复杂度在*O(n)*，空间复杂度在*O(1)*，这一点就限制了对数组首先进行排序，然后的操作。

首先考虑在 *O(n)* 复杂度上，那么HashMap在查询的时候只有*O(1)*的复杂度，维护一个HashMap，把数组中的所有数都放进去。然后从1开始进行遍历正整数，利用containsKey确定第一个在其中的正整数，返回值。

## 代码如下

```java
Map<Integer,Integer> map = new HashMap();
public int firstMissingPositive(int[] nums) {        
    for(int i =0;i<nums.length();i++){
        map.put(num[i]);
    }
    int i=1;
    while(true){
        if(!map.containsKey(i)){
            return i;
        }
        i++;
    }
}
```
虽然侥幸通过了测试，但是后来发现空间复杂度明显不符合要求，要想空间复杂度在*O(1)*，只能考虑使用题目给定的数组了。
对于该数组，其中包含非正整数和正整数，我们可以不保留那些非正整数，在遍历的过程中利用已遍历过的空间来按照顺序保存正整数。
比如

> 1 3 2 4

当遍历到元素3（index=1）的时候，可以把3放置到数组的index=2（因为2是数组的第三个位置）的位置，因为原本index=2的位置的元素还没有遍历，所以需要执行交换操作，防止数据丢失。操作后如下。

> 1 2 3 4

同时需要再次对index=1这个位置的新元素进行以上操作，这里发现新元素2无需进行上述操作，所以跳过。

那么分析一下不需要进行交换的情况或者无法进行交换的情况：

1. 元素已在合适的位置，比如上面元素2的位置已经正确。
2. 元素为负。 
3. 元素的合适位置已经超过了数组的长度。 
4. 元素与待交换位置的元素相等，无需交换。

以上就是基本的情况。其中元素为负和越界这两种情况代表着他们当前的位置有可能是缺少的正整数的应该在的位置（也有可能被后续的正整数所交换，但是交换后还会有新的空缺出现，）

当遍历一次数组执行完上述操作的以后，再遍历一次数组，第一个元素不对应index的就是缺少的那个正整数。

## 代码如下

```java
public int firstMissingPositive(int[] nums) {
    if(nums.length<1){
        return 1;
    }
        for(int i =0;i<nums.length;){
        if(nums[i]>0&& nums[i]-1<nums.length&&nums[i]!=nums[nums[i]-1]&&nums[i]!=i+1) {
            int temp =nums[i];
            nums[i]=nums[nums[i]-1];
            nums[temp-1]=temp;
        }else{
            i++;
        }
    }
    int i =0;
    while(i<nums.length){
        if(nums[i]!=i+1){
            return i+1;
        }
        i++;
    }
    return i+1;
}
```



