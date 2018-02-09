
/**
 * Created by yanqinghe on 2017/7/12.
 */
public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        String[] array = {"a"};
        System.out.print(solution.longestCommonPrefix(array));

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
        return pre;

    }
}
