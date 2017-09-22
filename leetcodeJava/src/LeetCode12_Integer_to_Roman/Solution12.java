package LeetCode12_Integer_to_Roman;

/**
 * Created by yanqinghe on 2017/7/12.
 */
public class Solution12 {
    public static void main(String[] args){
        Solution12 solution = new Solution12();
        System.out.print(solution.intToRoman(800));

    }
    public static final String[] roman =  {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public static final int[] val = {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
    public String intToRoman(int num) {
        StringBuffer stringBuffer = new StringBuffer();

        for(int i=0;num!=0;i++){
            while(num>=val[i]){
                num-=val[i];
                stringBuffer.append(roman[i]);
            }
        }
        return stringBuffer.toString();
    }
}
