import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution387 {
    public static void main(String[] args) {
        Solution387 solution387 = new Solution387();
        System.out.println(solution387.firstUniqChar("loveleetcode"));
    }
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int c  = chars[i]-'a';
            if(map[c]==0){
                map[c]=i+1;
            }else {
                map[c]=-1;
            }
        }
        int min =s.length()+1;
        for (int i : map) {
            if(i>0) min=Math.min(i-1,min);
        }
        return min>s.length()?-1:min;
    }
}
