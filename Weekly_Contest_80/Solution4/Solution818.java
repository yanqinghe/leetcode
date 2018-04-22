import java.util.*;

public class Solution818 {
    public int racecar(int target) {
        int[] dp = new int[target+3];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;dp[1]=1;dp[2]=4;
        for (int t=3;t<=target;t++){
            int k = 32-Integer.numberOfLeadingZeros(t);
            int number = (1<<k)-1;//2^k-1;
            if(t==(number)){
                dp[t]=k;
                continue;
            }
            for (int j =0;j<k-1;j++){
                dp[t]=Math.min(dp[t],dp[t-(1<<(k-1))+(1<<j)]+k-1+j+2);
            }
            if(number-t<t)
                dp[t]=Math.min(dp[t],dp[number - t]+k+1);
        }
        return dp[target];
    }

}
