# Two Sum

## 题目描述

_Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice_

### Example

 ```java
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 ```

### 中文描述

给定一个数组和一个目标值，返回和为目标值的两个数的索引值。假设每一个输入都有一个确定结果，同一个元素无法使用两次

### 解题方案

1. 首先想到的就是brute force算法，两层的循环解决问题，时间复杂度为O(n)，空间复杂度为常数。代码如下

```java
public int[] twoSum(int[] nums, int target) {
    int[] answer= new int[2];
    for(int i=0;i<nums.length;i++){
        answer[0]=nums[i];
        int temp = target-answer[0];
        for(int j=i;j<nums.length;j++){
            if(nums[j]==temp){
                return answer;
            }
        }
    }
    return answer;
}
 ```

2. 第二种方案就是考虑如何优化上一种算法了,这里看到网上的采用HashMap的方式来优化算法的时间复杂度。

``利用的是HashMap取数据时间是常数时间。``
 ```java
public int[] twoSum2(int[] nums, int target) {
    int[] res = new int[2];
    if(numbers==null||numbers.length<2) return null;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0;i<numbers.length;i++){
        if(map.containsKey(target-numbers[i])){
            res[0]=map.get(target-numbers[i])+1;
            res[1]=i+1;
            return res;
        }
        map.put(numbers[i],i);
    }
    return null;
 }
```

因为之前对于Java集合类的基础了解不够，所以不太理解所谓的HashMap取值操作为常数时间。于是查阅了相关资料,现记录一下。

> Java HashMap 是基于哈希表的Map接口实现，以Key-Value的形式在HashMap中，key-value总是会当做一个整体来处理，系统会根据hash算法来来计算key-value的存储位置，我们总是可以通过key快速地存、取value。下面就来分析HashMap的存取。
> #### HashMap的构造函数
> ``HashMap()：``构造一个具有默认初始容量 (16) 和默认加载因子 (0.75) 的空 HashMap。
> ``HashMap(int initialCapacity)：``构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。
> ``HashMap(int initialCapacity,  float loadFactor)：``构造一个带指定初始容量和加载因子的空 HashMap。

其中关于初始容量和加载因子和其他数据结构的概念相同，初始容量是创建哈希表d额初始大小，加载因子表示哈希表的最大填充程度。也就是当哈希表达到这个填充程度的时候，就需要对哈希表进行扩容。

#### HashMap存储

下面简单看一下hashMap的put方法源码

```java
public V put(K key, V value) {
    //当key为null，调用putForNullKey方法，保存null与table第一个位置中，这是HashMap允许为null的原因
    if (key == null)
        return putForNullKey(value);
    //计算key的hash值
    int hash = hash(key.hashCode());                  ------(1)
    //计算key hash 值在 table 数组中的位置
    int i = indexFor(hash, table.length);             ------(2)
    //从i出开始迭代 e,找到 key 保存的位置
    for (Entry<K, V> e = table[i]; e != null; e = e.next) {
        Object k;
        //判断该条链上是否有hash值相同的(key相同)
        //若存在相同，则直接覆盖value，返回旧value
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
            V oldValue = e.value;    //旧值 = 新值
            e.value = value;
            e.recordAccess(this);
            return oldValue;     //返回旧值
        }
    }
    //修改次数增加1
    modCount++;
    //将key、value添加至i位置处
    addEntry(hash, key, value, i);
    return null;
}
 ```

  通过源码我们可以清晰看到HashMap保存数据的过程为：首先判断key是否为null，若为null，则直接调用putForNullKey方法。若不为空则先计算key的hash值，然后根据hash值搜索在table数组中的索引位置，如果table数组在该位置处有元素，则通过比较是否存在相同的key，若存在则覆盖原来key的value，否则将该元素保存在链头（最先保存的元素放在链尾）。若table在该处没有元素，则直接保存。保存的过程看起来十分简单，但是其中有一部分比较重要的就是求Hash值函数

```java

static int hash(int h) {
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
}
  ```

对于HashMap的table而言，数据分布需要均匀（最好每项都只有一个元素，这样就可以直接找到），不能太紧也不能太松，太紧会导致查询速度慢，太松则浪费空间。计算hash值后，怎么保证数据的分布呢？HashMap调用indexFor方法。

 ``` java
static int indexFor(int h, int length) {
    return h & (length-1);
}
 ```

这个函数我在一开始没有理解到底什么意思，通过看别人的讲解后发现这个函数的作用和取模运算是相同的。具体计算的结果可以看下面的表格。

| h   | length-1 | h&length-1     | result |
|-----|----------|----------------|--------|
| 0   | 14       | 0000&1110=0000 | 0      |
| 1   | 14       | 0001&1110=0000 | 0      |
| 2   | 14       | 0010&1110=0010 | 2      |
| 3   | 14       | 0011&1110=0010 | 2      |
| 4   | 14       | 0100&1110=0100 | 4      |
| 5   | 14       | 0101&1110=0100 | 4      |
| 6   | 14       | 0110&1110=0110 | 6      |
| 7   | 14       | 0111&1110=0110 | 6      |
| 8   | 14       | 1000&1110=1000 | 8      |
| 9   | 14       | 1001&1110=1000 | 8      |
| 10  | 14       | 1010&1110=1010 | 10     |
| 11  | 14       | 1011&1110=1010 | 10     |
| 12  | 14       | 1100&1110=1100 | 12     |
| 13  | 14       | 1101&1110=1100 | 12     |
| 14  | 14       | 1110&1110=1110 | 14     |
| 15  | 14       | 1111&1110=1110 | 14     |

从上面的图表中我们看到总共发生了8此碰撞，同时发现浪费的空间非常大，有1、3、5、7、9、11、13、15处没有记录，也就是没有存放数据。这是因为他们在与14进行&运算时，得到的结果最后一位永远都是0，即0001、0011、0101、0111、1001、1011、1101、1111位置处是不可能存储数据的，空间减少，进一步增加碰撞几率，这样就会导致查询速度慢。而当length = 16时，length – 1 = 15 即1111，那么进行低位&运算时，值总是与原来hash值相同，而进行高位运算时，其值等于其低位值。所以说当length = 2^n时，不同的hash值发生碰撞的概率比较小，这样就会使得数据在table数组中分布较均匀，查询速度也较快。

#### 读取的实现

相对于HashMap的存而言，取就显得比较简单了。通过key的hash值找到在table数组中的索引处的Entry，然后返回该key对应的value即可。

```java
public V get(Object key) {
    // 若为null，调用getForNullKey方法返回相对应的value
    if (key == null)
        return getForNullKey();
    // 根据该 key 的 hashCode 值计算它的 hash 码  
    int hash = hash(key.hashCode());
    // 取出 table 数组中指定索引处的值
    for (Entry<K, V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
        Object k;
        //若搜索的key与查找的key相同，则返回相对应的value
        if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
            return e.value;
    }
    return null;
}
```

从上面的代码当中我们就可以得到为什么HashMap可以以常数的时间进行存取数据了。

再写这篇文章的时候，在CSDN的博客发现了另外的解法，

> 先对数组进行排序，然后使用夹逼的方法找出满足条件的pair，原理是因为数组是有序的，那么假设当前结果比target大，那么左端序号右移只会使两个数的和更大，反之亦然。所以每次只会有一个选择，从而实现线性就可以求出结果。该算法的时间复杂度是O(nlogn+n)=O(nlogn)，空间复杂度取决于排序算法。

``` java
public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    if(numbers==null || numbers.length<2)
        return null;
    Arrays.sort(numbers);
    int l = 0;
    int r = numbers.length-1;
    while(l<r)
    {
        if(numbers[l]+numbers[r]==target)
        {
            res[0] = number[l];
            res[1] = number[r];
            return res;
        }
        else if(numbers[l]+numbers[r]>target) r--;
        else l++;
    }
    return null;
}
```

> 参考链接
> 1. http://blog.csdn.net/linhuanmars/article/details/19711387
> 2. http://www.cnblogs.com/chenssy/p/3521565.html

> 项目GitHub链接
https://github.com/yanqinghe/leetcode/blob/master/leetcodeJava/src/Two_Sum_1/Solution.java

PS：写在后面，现在开始补写文档记录刷leetcode的过程，也希望能把自己的想法记录下来与别人分享，同时也希望能够与更多的人交流。
GitHub主页https://github.com/yanqinghe/leetcode