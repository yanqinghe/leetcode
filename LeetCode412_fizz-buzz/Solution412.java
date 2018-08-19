import java.util.ArrayList;
import java.util.List;

public class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            ret.add(i+"");
        }
        for (int i = 3; i <=n ; i+=3) {
            ret.set(i,"Fizz");
        }
        for (int i = 5; i <=n ; i+=5) {
            ret.set(i,"Buzz");
        }
        for (int i = 15; i <=n ; i+=15) {
            ret.set(i,"FizzBuzz");
        }
        return ret;
    }
}
