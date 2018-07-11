public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int [] dp = new int[len+1];
        int i=1,j=0;
        while (i<len){
            if(s.charAt(i)==s.charAt(j)){
                dp[++i]=++j;
            }else if(j==0) ++i;
            else j=dp[j];
        }
        return dp[len]>0 && (dp[len] % (len - dp[len]) == 0);
    }
}
