import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution828 {
    public static void main(String[] args) {
        Solution828 solution828 = new Solution828();
        System.out.println(solution828.uniqueLetterString("ABABABAB"));
    }
    public final static long MOD = 1000000007;
    public int uniqueLetterString(String S) {
        char[] chars = S.toCharArray();
        long res = 0;
        for (int i = 0; i < chars.length; i++) {
            int left = i-1;
            for (; left >=0&&chars[left]!=chars[i] ; left--) ;
            int right = i+1;
            for (; right < chars.length&&chars[right]!=chars[i]; right++) ;
            res+=(long)(right-i)*(i-left);
        }
        return (int) (res%MOD);
    }


}
