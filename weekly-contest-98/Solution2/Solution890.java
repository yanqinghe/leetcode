import java.util.*;

public class Solution890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list= new ArrayList<>();
        char[] p = pattern.toCharArray();
        for (String word : words) {
            if(isP(word.toCharArray(),p)){
                list.add(word);
            }
        }
        return list;
    }
    private boolean isP(char[] str,char[] p) {
        if (str.length != p.length) return false;
        int len = str.length;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(str[i])) {
                if (map.get(str[i]) != p[i]) {
                    return false;
                }
            } else {
                if (set.contains(p[i])) {
                    return false;
                }
                map.put(str[i], p[i]);
                set.add(p[i]);
            }
        }
        return true;
    }
}
