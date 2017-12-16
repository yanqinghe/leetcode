
import java.util.*;

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
