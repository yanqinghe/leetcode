import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i1 = 0;
        int i2 =0;
        while (i1<g.length&&i2<s.length){
            if(g[i1]<=s[i2]){
                g[i1]=0;
                i1++;
            }
                i2++;
        }
        int cnt =0;
        for (int i : g) {
            if(i==0) cnt++;
        }
        return cnt;
    }
}
