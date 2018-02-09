
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
 * Time: 15:37
 */
public class Solution202 {
    public boolean isHappy(int n) {
        if(n<1) return false;
        Set<Integer> set = new HashSet<>();
        int newN,temp;
        while (n!=1 && !set.contains(n)){
            set.add(n);
            newN = 0;
            while (n > 0) {
                temp = n % 10;
                n /= 10;
                newN += temp * temp;
            }
            n = newN;
        }
        return n==1;
    }
}
