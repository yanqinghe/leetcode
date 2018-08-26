import java.util.*;

public class Solution893 {
    public int numSpecialEquivGroups(String[] A) {
        int len = A.length;
        Set<String> set = new HashSet<>(len);
        for (String s : A) {
            set.add(getList(s,s.length()));
        }
        return set.size();
    }
    String getList(String str,int len){
        List<Character> chars1= new LinkedList<>();
        List<Character> chars2= new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if((i&1)!=1){
                chars1.add(str.charAt(i));
            }else {
                chars2.add(str.charAt(i));
            }
        }
        Collections.sort(chars1);
        Collections.sort(chars2);
        chars1.addAll(chars2);
        StringBuilder sb= new StringBuilder();
        for (Character character : chars1) {
            sb.append(character);
        }
        return sb.toString();
    }



}
