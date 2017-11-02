package LeetCode91_Decode_Ways;

import java.util.HashMap;
import java.util.Map;

public class Solution91 {

    public int numDecodings(String s) {
        if(s==null||s.length()<1||s.charAt(0)=='0'){
            return 0;
        }
        int [] dp = new int[2];
        dp[0]=1;
        dp[1]=1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0'||s.charAt(i-1)>'2'){
                    return 0;
                }
                dp[1]=0;
            }
            int temp =dp[1];
            if((s.charAt(i-1)-'0')*10+s.charAt(i)-'0'<27){
                temp=temp+dp[0];
            }
            dp[0]=dp[1];
            dp[1]=temp;
        }
        return  dp[1];
    }
}
