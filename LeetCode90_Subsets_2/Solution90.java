
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(new ArrayList<>());
        if (nums == null || nums.length < 1) {
            return result;
        }
        Arrays.sort(nums);
        help(new ArrayList<>(), 0, 0, nums);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    private void help(List<Integer> list, int from, int l, int[] nums) {
        if (l == nums.length) {
            return;
        } else {
            for (int i = from; i < nums.length; i++) {
                if (i > from && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.add(nums[i]);
                result.add(new ArrayList<>(list));
                help(list, i + 1, l + 1, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
