import java.util.ArrayList;
import java.util.List;

public class Solution282 {
    public static void main(String[] args) {
        Solution282 solution282 = new Solution282();
        solution282.addOperators("123",6);
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        //如果给定的数据有问题直接返回
        if (num != null && num.length() > 0)
            help(res, num, target, "", 0, 0, 0);
        return res;

    }

    /**
     * @param res 结果List
     * @param num 题目给定的数字字符串
     * @param target 题目给定的目标结果
     * @param str 递归过程中得到的中间字符串
     * @param index 当前在字符串中的游标
     * @param preRes 上次递归后运算的结果
     * @param preVal 上次截取字符串所对应的值
     */
    private void help(List<String> res, String num, int target, String str, int index, long preRes, long preVal) {
        if (index == num.length()) {
            if (preRes == target) {
                //如果符合结果的要求
                res.add(str);
            }
        } else {
            for (int j = index + 1; j <= num.length(); j++) {
                if (j != index + 1 && num.charAt(index) == '0')
                    //如果当前子字符串对应的首字符为0，也就是出现05 ，066这种情况，那么视为不合格的，跳过该次递归
                    return;
                long curVal = Long.parseLong(num.substring(index, j));
                if (index == 0) {
                    //如果是第一个数字，就代表前面没有符号，直接进行下一轮
                    help(res, num, target, "" + curVal, j, curVal, curVal);
                } else {
                    //如果是第二个数字，代表前面有符号,如果是加法和减法，那么直接运算就可以了
                    help(res, num, target, str + "+" + curVal, j, preRes + curVal, curVal);
                    help(res, num, target, str + "-" + curVal, j, preRes - curVal, -curVal);
                    //如果是乘法，要注意之前的加减法的运算要取消。
                    help(res, num, target, str + "*" + curVal, j, preRes - preVal + preVal * curVal, preVal * curVal);
                }
            }
        }
    }
}