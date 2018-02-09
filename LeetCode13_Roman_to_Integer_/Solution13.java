
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanqinghe on 2017/7/12.
 */
public class Solution13 {
    public static void main(String[] args) {
        Solution13 solution = new Solution13();
        System.out.print(solution.romanToInt("DCXXI"));

    }

    //    public static final String[] roman1 =  {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
//    public static final char[] roman =  {'M','D','C','L','X','V','I'};
//    public static final int[] val = {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
    public static final Map<String, Integer> map = new HashMap<String, Integer>() {
        {
            put("M", 1000);
            put("D", 500);
            put("C", 100);
            put("L", 50);
            put("X", 10);
            put("V", 5);
            put("I", 1);
        }
    };

    public int romanToInt(String s) {
//        Map<String,Integer> map = new HashMap<String,Integer>();
//                map.put("M",1000);
//                map.put("D",500);
//                map.put("C",100);
//                map.put("L",50);
//                map.put("X",10);
//                map.put("V",5);
//                map.put("I",1);

        int result = 0;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < s.length(); i++) {
            temp1 = map.get(s.charAt(i) + "");
            if (temp1 > temp2) {
                result = result + temp1 - 2 * temp2;
            } else {
                result += temp1;
            }

            temp2 = temp1;

        }
        return result;
    }
}
