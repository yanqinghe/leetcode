
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        solution205.isIsomorphic("ab", "aa");
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (sMap.containsKey(c1)) {
                if (sMap.get(c1) != c2) return false;
            }
            if (tMap.containsKey(c2)) {
                if (tMap.get(c2) != c1) return false;
            }

            sMap.put(c1, c2);
            tMap.put(c2, c1);
        }
        return true;
    }
}
