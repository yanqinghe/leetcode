
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution730 {
    public static void main(String[] args) {
        Solution730 solution730 = new Solution730();
        solution730.countPalindromicSubsequences2("bccb");
    }
    Map<String,Boolean>  dp = new HashMap<>();
    public int countPalindromicSubsequences(String S) {
        //字符串的长度
        for (int len = 1; len <= S.length(); len++) {
            //字符串的起始位置
            for (int from = 0; from <=S.length()-len ; from++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(S.charAt(from));
                helpDP(from+1,S,stringBuilder,len-1);
            }
        }
        int count = 0;
        for (String str:dp.keySet()
             ) {
            if(dp.get(str)){
                count++;
            }
        }
        return count/(int)(Math.pow(10,9) + 7);
    }
    void helpDP (int from,String s,StringBuilder stringBuilder,int length){
        if(length==0){
            isPar(stringBuilder.toString());
            return;
        }
        for (int i = from; i <= s.length()-length; i++) {
            stringBuilder.append(s.charAt(i));
            helpDP(i+1,s,stringBuilder,length-1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
    void isPar(String str){
        if(str.length()==1||dp.containsKey(str)){
            dp.put(str,true);
        }else if(str.charAt(0)==str.charAt(str.length()-1)){
            if(str.length()==2 ||dp.containsKey(str.substring(1,str.length()-1))){
                dp.put(str,true);
            }
        }
    }
    public int countPalindromicSubsequences2(String S) {

        int n = S.length();
        int mod = 1000000007;
        char[] s = S.toCharArray();
        char[] rs = rev(Arrays.copyOf(s, n));
        int[][] ns = makeFatNext(s, 'a', 'z');
        int[][] nrs = makeFatNext(rs, 'a', 'z');
        long[][] dp = new long[n][n];
        for(int i = 0;i < 26;i++){
            int l = ns[i][0]-1;
            int r = n-nrs[i][0];
            if(l <= r){
                dp[l][r]++;
            }
        }

        long ans = 0;
        for(int len = n;len >= 1;len--){
            for(int i = 0;i+len-1 < n;i++){
                int j = i+len-1;
                ans += dp[i][j];
                if(i != j)ans += dp[i][j];
//					if(dp[i][j] != 0)tr(i, j, dp[i][j]);
                if(s[i] == s[j]){
                    for(int c = 0;c < 26;c++){
                        int l = ns[c][i+1]-1;
                        int r = n-nrs[c][n-j];
                        if(l <= r){
                            //						tr(i, j, l, r);
                            dp[l][r] += dp[i][j];
                            if(dp[l][r] >= mod)dp[l][r] -= mod;
                        }
                    }
                }
            }
        }
        return (int)(ans%mod);
    }

    public char[] rev(char[] a)
    {
        for(int i = 0, j = a.length-1;i < j;i++,j--){
            char c = a[i];
            a[i] = a[j];
            a[j] = c;
        }
        return a;
    }


    public int[][] makeFatNext(char[] s, char inf, char sup)
    {
        int n = s.length;
        int[][] next = new int[sup-inf+1][n+1];
        for(int i = 0;i < sup-inf+1;i++)next[i][n] = n+1;
        for(int i = s.length-1;i >= 0;i--){
            for(int j = 0;j < sup-inf+1;j++)next[j][i] = next[j][i+1];
            next[s[i]-inf][i] = i+1;
        }
        return next;
    }

}
