import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution830 {
    public static void main(String[] args) {
        Solution830 solution830 = new Solution830();
        System.out.println(solution830.largeGroupPositions("aaa"));
    }
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> lists = new ArrayList<>();
        char c = S.charAt(0);
        int cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            char cur = S.charAt(i);
            if(cur==c){
                cnt++;
            }else {
                c = cur;
                if(cnt>=3){
                    lists.add(Arrays.asList(i-cnt,i-1));
                }
                cnt=1;
            }
        }
        if(cnt>=3){
            lists.add(Arrays.asList(S.length()-cnt,S.length()-1));
        }
        return lists;
    }
}
