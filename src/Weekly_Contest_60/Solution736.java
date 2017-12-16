
import java.util.HashMap;
import java.util.Map;

public class Solution736 {
    public static void main(String[] args) {
        Solution736 solution736 = new Solution736();
        solution736.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))");
    }

    int pos;
    int len;
    String[] sp;

    public int evaluate(String expression) {
        //如果表达式为空，直接返回0
        if (expression == null) return 0;
        //处理表达式，将表达式中的语句和变量进行分割
        sp = expression.replace("(", "( ").replace(")", " )").trim().split(" ");
        //表达式的长度
        len = sp.length;
        //初始化位置
        pos = 0;
        //计算结果
        int ret = (int) expr(new HashMap<String, Long>());
        //判断表达式的合理性
        assert pos == len;
        return ret;
    }

    long expr(Map<String, Long> assign) {
        if (sp[pos].equals("(")) {
            //如果是表达式的开头
            pos++;
            //游标前进1
            if (sp[pos].equals("let")) {
                //如果当前操作是let,移动游标
                pos++;
                //定义当前let范围内的变量Map，用于保存(变量名，变量值)的映射
                Map<String, Long> scope = new HashMap<>(assign);
                while (true) {
                    if (sp[pos].equals("(") || sp[pos + 1].equals(")")) {
                        //如果如果当前位置是一个表达式，那么进行递归，计算该表达式的值
                        long ret = expr(scope);
                        //获取值，然后移动游标
                        pos++;
                        //返回当前let对应的值
                        return ret;
                    }
                    //如果当前位置不是一个表达式，那么将表达式的
                    scope.put(sp[pos++], expr(scope));
                }
            } else if (sp[pos].equals("add")) {
                //如果是add操作,移动游标
                pos++;
                //计算第一个的值
                long r1 = expr(assign);
                //计算第二个的值
                long r2 = expr(assign);
                //移动游标
                pos++;
                //返回add的结果
                return r1 + r2;
            } else if (sp[pos].equals("mult")) {
                //同add操作
                pos++;
                long r1 = expr(assign);
                long r2 = expr(assign);
                pos++;
                return r1 * r2;
            } else {
                //如果不是以上情况都是不是，抛出异常
                throw new RuntimeException();
            }
        } else {
            //如果刚开始不是"("，说明是变量或者常量
            try {
                //解析常量
                long x = Long.parseLong(sp[pos]);
                pos++;
                return x;
            } catch (NumberFormatException e) {
                //解析出现错误说明是变量，从变量map中获取变量对应的数值
                long ret = assign.get(sp[pos]);
                pos++;
                //返回结果
                return ret;
            }
        }
    }
}
