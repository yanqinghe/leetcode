package LeetCode_Contest56;


import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'};
        int i = solution2.compress(chars);
        return;
    }

    public int compress(char[] chars) {
        if (chars == null || chars.length < 1) {
            return 0;
        }
        int i = 1;
        char c = chars[0];
        int index = 0;
        for (int j = 1; j < chars.length; j++) {
            if (c != chars[j]) {
                index = help(chars, index, i, c);
                c = chars[j];
                i = 1;
            } else {
                i++;
            }
        }
        index = help(chars, index, i, c);
        return index;
    }

    private int help(char[] chars, int index, int count, char c) {
        chars[index] = c;
        index++;
        if (count != 1) {

            List<Character> list = new ArrayList();
            while (count > 0) {
                list.add((char) (count % 10 + '0'));
                count = count / 10;
            }
            for (int j = list.size() - 1; j >= 0; j--) {
                chars[index] = list.get(j);
                index++;
            }

        }
        return index;
    }
}
