package LeetCode65_Valid_Number;

import java.util.LinkedList;
import java.util.List;

public class Solution65 {

    public static void main(String[] args) {
        Solution65 solution65 = new Solution65();
        List<String> testdata = new LinkedList<>();
        testdata.add(".1");//True
        testdata.add("1.");//True
        testdata.add("0"); // True
        testdata.add(" 0.1 "); // True
        testdata.add("abc"); // False
        testdata.add("1 a"); // False
        testdata.add("2e10"); // True

        testdata.add("-e10"); // False
        testdata.add(" 2e-9 "); // True
        testdata.add("+e1"); // False
        testdata.add("1+e"); // False
        testdata.add(" "); // False

        testdata.add("e9"); // False
        testdata.add("4e+"); // False
        testdata.add(" -."); // False
        testdata.add("+.8"); // True
        testdata.add(" 005047e+6"); // True

        testdata.add(".e1"); // False
        testdata.add("3.e"); // False
        testdata.add("3.e1"); // True
        testdata.add("+1.e+5"); // True
        testdata.add(" -54.53061"); // True

        testdata.add(". 1"); // False
        for (String test:testdata
             ) {
            System.out.println("args = [" + solution65.isNumber(test) + "]");
        }
    }
    //可以通过的条件
    //1 只有数字和空格
    //2 出现正负号，必须是第一位或者在e后面的第一位，后面要紧跟数字
    //3 出现小数点， 前面不能有小数点出现或者e出现，小数点前面是数字（不能再第一位）和小数点后面是数字(不能在最后一位)
    //4 出现e/E，前面不能出现过e/E，不能是第一位和最后一位
    public boolean isNumber(String s) {
        if(s==null){
            return false;
        }
        s= s.trim();//去除前后的空格
        if(s.length()<1){
            return false;
        }
        boolean  dotExist  = false;//小数点判断
        int  pExist = -1;//正负号判断
        int  eExist =-1;//e判断
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                case '+':
                case '-':
                    //如果出现正负号
                    if(i!=0 && i!= eExist+1 || i==s.length()-1){
                        //如果重复出现或者不在第一位和e后面的一位
                        return false;
                    }
                    pExist=i;
                    break;
                case '.':
                    //如果出现小数点
                    if(dotExist||eExist!=-1||((i==0||!(s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'))
                            && (i==s.length()-1||!(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9')))){
                        return false;
                    }
                    dotExist=true;
                    break;
                case 'e':
                case 'E':
                    //如果出现e
                    if(eExist!=-1||i==0||i==s.length()-1 ||pExist+1==i){
                        return false;
                    }
                    eExist=i;
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
