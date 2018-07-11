import java.util.HashSet;
import java.util.Set;

public class Solution367 {
    public static void main(String[] args) {
        for (int i = 0; i < 46341; i++) {
            System.out.println(i*i);
        }
    }
    public boolean isPerfectSquare(int num) {
        for(int i = 1; num > 0; i += 2){
            num -= i;
        }
        return num == 0;
    }
}
