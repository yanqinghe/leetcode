package LeetCode166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;
import org.omg.CORBA.INTF_REPOS;

public class Solution166 {
    public static void main(String[] args) {
        Solution166 solution166 = new Solution166();
        System.out.println( solution166.fractionToDecimal(-1,-2147483648));

    }
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        boolean isP = true;

        long number = numerator;
        long de = denominator;
        StringBuilder sb = new StringBuilder();
        if(de*number<0) sb.append("-");
        number=Math.abs(number);

         de = Math.abs(de);

        //首先计算整数部分
        while(number>=de){
            sb.append(number/de);
            number = number%de;
        }

        if(number==0){
            return sb.toString();
        }
        if(sb.length()<1||sb.charAt(sb.length()-1)=='-') sb.append("0");
        //计算小数部分，小数部分要考虑小数的循环问题。小数的循环问题
        Map<Long,Integer> map = new HashMap<>();
        StringBuilder xiaosu  = new StringBuilder();
        int index = 0;
        while (number!=0){
            if(map.containsKey(number)){
                xiaosu.insert(map.get(number),"(");
                xiaosu.append(")");
                break;
            }
            map.put(number,index);
            number*=10;
            xiaosu.append(number/de);
            number=number%de;
            index++;
        }
        return sb.append(".").append(xiaosu).toString();
    }
}
