package LeetCode201_Bitwise_AND_of_Numbers_Range;

/**
 * Created with Hehel
 * . . . . . . . . . . . ._oo0oo_
 * . . . . . . . . . . . o8888888o
 * . . . . . . . . . . . 88" . "88
 * . . . . . . . . . . . (| -_- |)
 * . . . . . . . . . . . 0\  =  /0
 * . . . . . . . . . . ___/`---'\___
 * . . . . . . . . ..' \\|     |// '.
 * . . . . . . . . / \\|||  :  |||// \
 * . . . . . . . ./ _||||| -:- |||||- \
 * . . . . . . . |   | \\\  -  /// |   |
 * . . . . . . . | \_|  ''\---/''  |_/ |
 * . . . . . . . \  .-\__  '-'  ___/-. /
 * . . . . . . . . .___'. .'  /--.--\  `. .'___
 * . . . . . . .."" '<  `.___\_<|>_/___.' >' "".
 * . . . . | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * . . . . \  \ `_.   \_ __\ /__ _/   .-` /  /
 * . .=====`-.____`.___ \_____/___.-`___.-'=====
 * `=---='
 * <p>
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * 佛祖保佑         永无BUG
 * Description:
 * User: Hehel
 * Date: 2017-12-11
 * Time: 14:24
 */
public class Solution201 {
    public static void main(String[] args) {
        Solution201 solution201 = new Solution201();
        solution201.rangeBitwiseAnd2(6,7);
    }
    public int rangeBitwiseAnd(int m, int n) {
        // 范围出现错误或者100b和1000b这种情况进行运算
        if(m==n) return m;
        int count =0;
        int res = 0;
        while (m>0){
            if((m&1) == (n&1)){
                //如果m，n当前位是相同的
                res +=( (m&1) << count);
            }else {
                //如果m,n当前位是不同的
                res = 0;
            }
            m>>=1;n>>=1;
            count++;
        }
        if(n!=0) return 0;
        return  res;
    }
    public int rangeBitwiseAnd2(int m, int n) {
        int hb = Integer.reverse(n);
        hb = Integer.reverse(hb&(-hb));
        while(hb > 0 && ((n&hb) == (m&hb))) hb>>=1;
        return hb == 0? n : n&(~((hb<<1)-1));
    }
}
