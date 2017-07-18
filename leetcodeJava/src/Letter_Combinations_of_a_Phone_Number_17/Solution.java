package Letter_Combinations_of_a_Phone_Number_17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanqinghe on 2017/7/15.
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.print(solution.letterCombinations("23"));
    }

    public static char[][] letters = {
            {'a','b','c'},//2
            {'d','e','f'},//3
            {'g','h','i'},//4
            {'j','k','l'},//5
            {'m','n','o'},//6
            {'p','q','r','s'},//7
            {'t','u','v'},//8
            {'w','x','y','z'}//9
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length()<1){
            return result;
        }
        char[]temp = letters[digits.charAt(0)-'2'];
        for(int j=0;j<temp.length;j++){
            result.add(temp[j]+"");
        }
        for(int i=1;i<digits.length();i++){
            List<String> resultTemp = new ArrayList<String>();
            if(digits.charAt(i)-'1'>0){
                temp = letters[digits.charAt(i)-'2'];
                for(int j=0;j<temp.length;j++){
                    for (String str:
                         result) {
                        resultTemp.add(str+temp[j]);
                    }
                }
                result=resultTemp;
            }else {
                continue;
            }
        }
        return result;
    }
}
