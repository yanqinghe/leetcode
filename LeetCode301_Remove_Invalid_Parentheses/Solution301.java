import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution301 {
    public static void main(String[] args) {
        Solution301 solution301 = new Solution301();
        solution301.removeInvalidParentheses("()())()");
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s,')',0,res);
        return res;
    }

    public void remove(String s, char c, int last, List<String> res) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('||s.charAt(i) == ')') {
                count = s.charAt(i)==c?count+1:count-1;
                if (count > 0) {
                    //如果count>0,说明有额外的当前括号，或者是左或者是右，需要删除
                    //删除的规则是任何一个括号都可以，但是要注意。两个连续的括号删除的时候是等价的
                    for (int j = last; j <= i; j++) {
                        //从上次删除位置开始遍历到当前位置
                        if (s.charAt(j) == c && (j == last || s.charAt(j - 1) != c))
                            //删除括号
                            remove(s.substring(0, j) + s.substring(j + 1), c, j, res);
                    }
                    return;
                }
            }
        }
        //反转字符串，对左括号进行处理
        s = new StringBuffer(s).reverse().toString();
        if(c==')') {
            remove(s,'(',0,res);
            return;
        }
        //添加结果
        res.add(s);
    }
}