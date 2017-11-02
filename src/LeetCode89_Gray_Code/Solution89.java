package LeetCode89_Gray_Code;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0) {
            return result;
        }
        List<Integer> tmp = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        result = new ArrayList<Integer>(tmp);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            result.add(addNumber + tmp.get(i));
        }
        return result;
    }
}
