package LeetCode6_ZigZag_conversion;

/**
 * Created by yanqinghe on 2017/7/3.
 */
public class Solution6 {
    public static void main(String[] args){
        Solution6 solution= new Solution6();
        System.out.print(solution.convert("0123456789",4));
    }
    public String convert(String s, int numRows) {
        if(s==null||s.length()<=numRows||numRows==1){
            return s;
        }
        StringBuffer  result= new StringBuffer();
        int ti = numRows+(numRows-2);
        for(int j =0;j<s.length();j+=ti){
            result.append(s.charAt(0+j));
        }
        for(int i=1;i<numRows-1;i++){
            for(int j =i;j<s.length();j+=ti){
                result.append(s.charAt(j));
                int index = ti-2*i+j;
                if(index<s.length()){
                    result.append(s.charAt(index));
                }
            }
        }
        for(int j = numRows-1;j<s.length();j+=ti){
            result.append(s.charAt(j));
        }
        return result.toString();
    }
}
