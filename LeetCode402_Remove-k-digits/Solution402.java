import java.util.*;

public class Solution402 {
    public static void main(String[] args) {
        Solution402 solution402 = new Solution402();
        System.out.println(solution402.removeKdigits("10200",1));
    }
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        int len = chars.length;
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i <len ; i++) {
            //遍历每一位
            while (!stack.isEmpty() && chars[i] < chars[stack.peek()]) {
                //当stack不等于空且当前数字小于栈顶数字的时候
                //移除栈顶数字，并且把该数字删除
                chars[stack.pop()]=0;
                cnt++;
                //如果已经完成剔除任务，直接返回
                if(cnt==k) return getRes(chars);
            }
            //如果stack为空，直接放入stack内
            //如果当前数字大于栈顶数字，那么也填入stack中
            stack.add(i);
        }
        for (; cnt < k; cnt++) {
            chars[stack.pop()]=0;
        }
        return getRes(chars);
    }

    String getRes(char[] chars){
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < chars.length; j++) {
            if(chars[j]!=0) {
                if(sb.length()==0&&chars[j]=='0') continue;
                sb.append(chars[j]);
            }
        }
        return sb.length()==0?"0":sb.toString();
    }
}
