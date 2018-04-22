import java.util.Map;

public class Solution318 {
    public static void main(String[] args) {
        Solution318 solution318 = new Solution318();
        System.out.println(solution318.maxProduct(new String[]{
                "abcw", "baz", "foo", "bar", "xtfn", "abcdef"
        }));
    }
    public int maxProduct(String[] words) {
        //利用二进制保存每个字符串所包含的字符。比如如果有字母c,那么c-a=2,对应的第三位就为1，利用<<运算符和!=运算符进行统计
        int len = words.length;
        int[] help = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                help[i]|=(1<<(words[i].charAt(j)-'a'));
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                //当两个数字的位与运算结果为0，说明每一位都没有相同的即代表两个字符串没有包含相同字符
                if((help[i]&help[j])==0){
                    max= Math.max(words[i].length()*words[j].length(),max);
                }
            }
        }
        return max;
    }
}
