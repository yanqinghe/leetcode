package Weekly_Contest_59;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <=right; i++) {
            if(helpDivid(i)) res.add(i);
        }
        return res;
    }
    boolean helpDivid(int i){
        String strI = i+"";
        char[] chars = strI.toCharArray();

        for (int j = 0; j < chars.length; j++) {

            if(chars[j]=='0'||i%(chars[j]-'0')!=0){
                return false;
            }
        }
        return true;
    }
}
