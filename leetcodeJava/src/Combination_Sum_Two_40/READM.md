# Combination Sum II   

## 问题表示

>Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

>Each number in C may only be used once in the combination.

>Note:
> 1. All numbers (including target) will be positive integers.
> 2. The solution set must not contain duplicate combinations.
> 3. For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 

```
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

这道题与上一道题也就是Combination Sum是类似的题目，不过在上一道题中，元素本身不重复，但是可以重复使用，在第二道题中，元素本身会重复，但是不能重复使用。所以程序结构基本是相似的。比较重要的一个点就是，如果去重复。

我直接使用了Set去存储符合条件的解，最后在直接转化为List，这只是比较偷懒的办法，可以在每次添加的时候都进行判断。在这里就不表述。

## 代码实现

```java
public class Solution40 {
    Set<List<Integer>> result = new HashSet<>();
    //这里与上一道题不同的是使用Set来去除重复的解，
    //    Map<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //首先对数组进行排序
        Arrays.sort(candidates);

        help(candidates, 0, new ArrayList<>(), target);
        //将Set转化为List
        List<List<Integer>> r = new ArrayList<>(result);
        return r;

    }

    public void help(int[] candidates, int i, List<Integer> list, int target) {
        if (target == 0) {

            List<Integer> integerList = new ArrayList<>(list);
            result.add(integerList);
        }
        for (int j = i; j < candidates.length && candidates[j] <= target; j++) {
            list.add(candidates[j]);
            //这里有所不同的是传入的是j+1，因为每个元素不能重复的使用
            help(candidates, j + 1, list, target - candidates[j]);

            list.remove(list.size() - 1);
        }


    }
}
```