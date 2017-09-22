package LeetCode8_String_to_Integer;

/**
 * Created by yanqinghe on 2017/7/4.
 */
public class Solution8 {

    public static void main(String[] args){
        Solution8 solution8 = new Solution8();
        System.out.print(solution8.myAtoi("      -11919730356x"));
    }
/*
* 输入的格式 "
* +0 123"   123
*
* */
    public int myAtoi(String str) {
        if(str==null||str.length()<1){
            return 0;
        }
        str=str.trim();
        int i=0;
        if(str.length()>1&&(str.charAt(0)=='-'||str.charAt(0)=='+')) i=1;

        int result=0;
        for(;i<str.length();i++){
            int temp = str.charAt(i)-'0';
            if(temp<0||temp>9){
                return str.charAt(0)=='-'?-result:result;
            }
            int tempR = result*10;
            if(result*10/10!=result||(tempR+temp)<tempR){
                return str.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            result = temp+tempR;
        }
        return str.charAt(0)=='-'?-result:result;
    }
}
