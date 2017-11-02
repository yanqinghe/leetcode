package LeetCode22_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hehe on 2017/7/17.
 */
public class Solution22 {
    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        System.out.print(solution.generateParenthesis(3));
    }

    public List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", n, n);
        return list;
    }

    public void backtrack(String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            backtrack(str + "(", left - 1, right);
        }
        if (right > 0) {
            backtrack(str + ")", left, right - 1);
        }
    }
}
