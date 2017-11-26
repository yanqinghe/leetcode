package Weekly_Contest_60;

import LeetCode2_Add_2_Numbers.ListNode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String[] w1={"one","excellent","meal"};
        String[] w2= {"one","good","dinner"};
String[][] pars = {{"great","good"},{"extraordinary","good"},{"well","good"},{"wonderful","good"},{"excellent","good"},{"fine","good"},{"nice","good"},{"any","one"},{"some","one"},{"unique","one"},{"the","one"},{"an","one"},{"single","one"},{"a","one"},{"truck","car"},{"wagon","car"},{"automobile","car"},{"auto","car"},{"vehicle","car"},{"entertain","have"},{"drink","have"},{"eat","have"},{"take","have"},{"fruits","meal"},{"brunch","meal"},{"breakfast","meal"},{"food","meal"},{"dinner","meal"},{"super","meal"},{"lunch","meal"},{"possess","own"},{"keep","own"},{"have","own"},{"extremely","very"},{"actually","very"},{"really","very"},{"super","very"}}
 ;
solution2.areSentencesSimilar(w1,w2,pars);
    }
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        Map<String,Set<String>> map = new HashMap<>();
        if(words1.length!=words2.length) return false;
        for (int i = 0; i < pairs.length; i++) {
            if(map.containsKey(pairs[i][0])){
                map.get(pairs[i][0]).add(pairs[i][1]);
            }else {
                Set<String> strSet = new HashSet();
                strSet.add(pairs[i][1]);
                map.put(pairs[i][0],strSet);
            }
            if(map.containsKey(pairs[i][1])){
                map.get(pairs[i][1]).add(pairs[i][0]);
            }else {
                Set<String> strSet = new HashSet();
                strSet.add(pairs[i][0]);
                map.put(pairs[i][1],strSet);
            }

        }
        for (int i = 0; i <words1.length; i++) {
            if(words1[i].equals(words2[i])||(map.containsKey(words1[i])&&map.get(words1[i]).contains(words2[i]))){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

}
