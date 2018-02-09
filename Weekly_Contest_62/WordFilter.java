
import java.util.*;

public class WordFilter {
    private  Map<String,Set<Integer>> preFixMap = new HashMap<>();
    private Map<String,Set<Integer>> sufFixMap  = new HashMap<>();
    public WordFilter(String[] words) {
        int i = 0;
        for (String word : words) {
            for (int l = 0; l <= word.length(); l++) {
                String prefix = word.substring(0, l);
                if (!preFixMap.containsKey(prefix)) {
                    preFixMap.put(prefix, new TreeSet<>());
                }
                preFixMap.get(prefix).add(-i);
                String suffix = word.substring(word.length() - l);
                if (!sufFixMap.containsKey(suffix)) {
                    sufFixMap.put(suffix, new TreeSet<>());
                }
                sufFixMap.get(suffix).add(-i);
            }
            i++;
        }

    }

    public int f(String prefix, String suffix) {
        if(!(preFixMap.containsKey(prefix)&&sufFixMap.containsKey(suffix))) {
            return -1;
        }
        Set<Integer> prefixSet = preFixMap.get(prefix);
        Set<Integer> suffixSet = sufFixMap.get(suffix);
        if (prefixSet.size() > suffixSet.size()) {
            Set<Integer> t = prefixSet;
            prefixSet = suffixSet;
            suffixSet = t;
        }
        for (Integer integer : prefixSet) {
            if (suffixSet.contains(integer)) {
                return -integer;
            }
        }
        return -1;

    }

}
