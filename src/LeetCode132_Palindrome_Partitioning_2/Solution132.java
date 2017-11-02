package LeetCode132_Palindrome_Partitioning_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution132 {
    public static void main(String[] args) {
        Solution132 solution132 = new Solution132();
        solution132.minCut2("a");
    }
    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        dp[0][0]=0;

        for (int i = 1; i < s.length(); i++) {
            for (int j = i-1; j >=0; j--) {
                if(i-1==j){
                    dp[i][j]=s.charAt(i)==s.charAt(j)?0:1;
                }else {
                    if(dp[i-1][j]==dp[i][j+1]){
                        dp[i][j]=dp[i-1][j+1]==1?0:dp[i-1][j]+1;
                    }else {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j+1]);
                    }

                }
            }
        }
        return dp[s.length()-1][0];
    }
    public int minCut2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] res = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if(i==j||(i==j+1||dp[i-1][j+1])&& s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    res[i+1]=res[i+1]==0?res[j]+1:Math.min(res[j]+1,res[i+1]);
                }
            }
        }
        return res[s.length()]-1;
    }
}
