import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution796 {
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()) return false;
        Set<String> set =new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            set.add(A.substring(i,A.length())+A.substring(0,i));
        }
        if(set.contains(B)) return true;
        else return false;
    }
}
