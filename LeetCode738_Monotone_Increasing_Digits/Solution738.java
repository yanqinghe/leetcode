import java.util.Arrays;

public class Solution738 {
    public static void main(String[] args) {
        Solution738 solution738 = new Solution738();
        System.out.println(solution738.monotoneIncreasingDigits(10));
    }
    public int monotoneIncreasingDigits(int N) {
        char[] chars = (N+"").toCharArray();
        char[][] dp = new char[chars.length][2];
        dp[0][0]='0';
        dp[0][1]=chars[0];
        for (int i = 1; i < chars.length; i++) {
            dp[i][0]=dp[i-1][1];
            dp[i][1]=chars[i];
            if(dp[i][0]>dp[i][1]){
                //如果上下线冲突[6,5]，那么该位设置为9,反向求解。
                Arrays.fill(chars,i,chars.length,'9');
                for (int j = i-1; j >=0 ; j--) {
                    dp[j][1]--;
                    if(dp[j][1]<dp[j][0]){
                        //如果继续冲突
                        chars[j]='9';
                    }else {
                        //如果不在冲突，计算结果
                        chars[j]--;
                        return Integer.parseInt(String.valueOf(chars));
                    }
                }
            }
        }
        //如果原数字符合要求，直接返回
        return N;
    }
}
