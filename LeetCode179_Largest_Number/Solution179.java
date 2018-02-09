

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution179 {
    public String largestNumber(int[] nums) {
        //如果nums为空，直接返回
        if(nums==null||nums.length<1) return "";
        //首先将int数
        String [] strings = new String[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
            sum+=nums[i];
        }
        //去掉数字开头的0，如输入[0, 0]

        if (sum == 0) return "0";
        StringBuilder res= new StringBuilder();
        Arrays.sort(strings,new SortHelp());
        for (int i = strings.length-1; i >=0 ; i--) {
            res.append(strings[i]);
        }

        return res.toString();
    }
    class SortHelp implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return  o1.concat(o2).compareTo( o2.concat(o1));
        }
    }
}
