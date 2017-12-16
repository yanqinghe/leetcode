
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
    public static void main(String[] args) {
        Solution30 solution = new Solution30();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {
                "word", "good", "best", "good"
        };
        System.out.print(solution.findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < 1 || words == null || words.length < 1) {
            return res;
        }
        int wordLength = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        Map<String, Integer> curMap = new HashMap<>();
        curMap.putAll(map);
        for (int i = 0; i <= s.length() - wordLength * words.length; i++) {

            int left = i;
            String str = s.substring(left, left + wordLength);

            int count = 0;
            while (curMap.containsKey(str) && curMap.get(str) > 0) {
                curMap.put(str, curMap.get(str) - 1);
                count++;
                left += wordLength;
                if (left + wordLength > s.length())
                    break;
                str = s.substring(left, left + wordLength);
            }
            if (count == words.length) {
                res.add(i);
            }
            if (count > 0) {
                curMap.clear();
                curMap.putAll(map);
            }

        }
        return res;
    }
}
