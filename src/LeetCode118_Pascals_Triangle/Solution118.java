package LeetCode118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>() {{
            add(1);
        }});
        List<Integer> pre = res.get(0);
        while (numRows > 1) {
            List<Integer> temp = new ArrayList<>();
            int preInt = 0;
            for (int i : pre) {
                temp.add(i + preInt);
                preInt = i;
            }
            temp.add(preInt);
            res.add(temp);
            pre = temp;
            numRows--;
        }
        return res;
    }
}
