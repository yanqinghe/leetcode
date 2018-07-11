import java.util.HashSet;
import java.util.Set;

public class Solution326 {


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if(Math.pow(3,i)>Integer.MAX_VALUE){
                break;
            }
            System.out.print((int)Math.pow(3,i)+",");
        }
    }
    final static int[] table = new int[]{
            1,3,9,27,81,243,729,2187,6561,19683,59049,177147,531441,1594323,4782969,14348907

    };
    public boolean isPowerOfThree(int n) {
        for (int i : table) {
            if(n==i) return true;
        }
        return false;
    }
}
