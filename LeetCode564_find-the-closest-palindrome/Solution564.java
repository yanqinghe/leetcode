import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution564 {
    public static void main(String[] args) {
        Solution564 solution564= new Solution564();
        System.out.println(solution564.nearestPalindromic("100"));
    }
    long cur = 0;
    long minD = 0;
    long ret = 0;
    short[] dir = {1,-1,0};
    public String nearestPalindromic(String n) {
        int len  = n.length();
        ret =0;
        cur = Long.valueOf(n);
        minD = Long.MAX_VALUE;
        Set<Long> set = new HashSet<>();
        char[] chars1 = new char[len+1];
        Arrays.fill(chars1,'0');
        chars1[0]='1';
        chars1[len]='1';
        set.add(Long.valueOf(String.valueOf(chars1)));
        if(len>1){
            char[] chars2 = new char[len-1];
            Arrays.fill(chars2,'9');
            set.add(Long.valueOf(String.valueOf(chars2)));
        }
        String str ;
        for (short i : dir) {
            StringBuilder sb = new StringBuilder();
            char[] chars = String.valueOf(cur+(long)(i*Math.pow(10,len/2))).toCharArray();
            for (int j = 0; j < chars.length/2; j++) {
                chars[chars.length-1-j]=chars[j];
            }
            set.add(Long.valueOf(String.valueOf(chars)));
        }
        set.remove(cur);
        for (Long aLong : set) {
            help(aLong);
        }
        return ret+"";
    }

    private void help(long num){
        long d = Math.abs(num-cur);
        if(d<minD){
            ret= num;
            minD=d;
        }else if(d==minD){
            ret = Math.min(ret,num);
        }
    }
}
