
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    // 定义结果list
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 首先对候选数组进行排序操作
        Arrays.sort(candidates);
        // 执行递归操作
        getList(new ArrayList(), candidates, 0, target);
        return result;
    }

    public void getList(List<Integer> list, int[] candidates, int i, int target) {
        if (target == 0) {
            // 如果target=0，也就是list满足和为目标值，那么新建一个List对象，
            List<Integer> arrayList = new ArrayList<Integer>(list);
            // 将新建的list对象添加到结果List中
            result.add(arrayList);
        } else {
            // 从当前i开始，枚举i后（包括i）的所有候选元素，（如果元素大于target值，那么直接终止）
            for (int j = i; j < candidates.length && candidates[j] <= target; j++) {
                list.add(candidates[j]);
                // 继续进行递归
                getList(list, candidates, j, target - candidates[j]);
                // 在这里需要对list进行恢复操作。
                list.remove(list.size() - 1);
            }
        }

    }
}
