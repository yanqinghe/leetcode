import java.util.ArrayList;
import java.util.List;

public class Solution821 {
    public static void main(String[] args) {
        Solution821 solution821 = new Solution821();
        solution821.shortestToChar("loveleetcode",'e');
    }
    public int[] shortestToChar(String S, char C) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)==C){
                list.add(i);
            }
        }
        list.add(Integer.MAX_VALUE);
        int l =0;
        int r =1;
        int[] dis = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            int ld = Math.abs(i-list.get(l));
            int rd = Math.abs(i-list.get(r));
            if(ld<rd){
                dis[i]=ld;
            }else {
                dis[i]=rd;
                l++;
                r++;
            }
        }
        return dis;
    }
}
