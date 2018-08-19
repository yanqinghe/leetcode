import java.util.ArrayList;
import java.util.List;

public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <=right ; i++) {
            if(is(i)) res.add(i);
        }
        return res;
    }
    private boolean is(int num){
        for (char c : String.valueOf(num).toCharArray()) {
            if(c=='0'||num%(c-'0')!=0) return false;
        }
        return true;
    }
}
