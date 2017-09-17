package Reverse_Integer_7;

/**
 * Created by yanqinghe on 2017/7/3.
 */
public class Solution7 {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        int a = 1000000003;
        System.out.println(a * a);
        System.out.print(solution.reverse2(1000000004));
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
//            if((result<0&&(result*10)>0 )||(result>0&&(result*10)<0)){
//                return 0;
//            }
            if (result * 10 / 10 != result) return 0;
            result = x % 10 + result * 10;
            x = x / 10;
        }
        return result;
    }

    public int reverse2(int x) {
        String s = x >= 0 ? x + "" : -x + "";
        int i = s.length() - 1;
        int result = 0;
        while (i >= 0) {
            int temp = s.charAt(i) - '0';
            if (result * 10 / 10 != result) return 0;
            result = temp + result * 10;
            i--;
        }
        return x>=0?result:-result;

    }

}
