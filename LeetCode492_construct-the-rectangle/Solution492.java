import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution492 {
    public static void main(String[] args) {
        Solution492 solution492 = new Solution492();
        System.out.println(Arrays.toString(solution492.constructRectangle(44)));
    }
    public int[] constructRectangle(int area) {
        int l = 0;
        int w = 0;
        l=w=(int)Math.sqrt(area);
        while (l<=area&&w>=1){
            int a = l*w;
            if(a<area)
                l++;
            else if(a>area)
                w--;
            else
                return new int[]{l,w};
        }
        return new int[]{1,area};

    }
}
