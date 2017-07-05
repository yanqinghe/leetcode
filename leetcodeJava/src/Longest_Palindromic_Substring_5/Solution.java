package Longest_Palindromic_Substring_5;

/**
 * Created by yanqinghe on 2017/7/2.
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome2("aaaa"));
    }

//   采用普通算法，算法思路，便利字符串的前n-1个位置，然后将这些位置作为回文字符串的中心点，求解最大的回文字符串。
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        int len =s.length();
        if(len<=1){
            return s;
        }
        for(int i =0;i<len-1;i++) {
            longestSubString(s, i, i);//以i为中心
            longestSubString(s, i, i + 1);//以i+0.5为中心
        }
        return s.substring(lo,lo+maxLen);
    }
    public void longestSubString(String s,int i,int j){
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(maxLen<j-i-1){
            maxLen=j-i-1;
            lo=i+1;
        }
    }
//采用动态规划

public String longestPalindrome2(String s) {
    int len = s.length();
    int maxLen=0;

    int lo=0;
    if(s==null||len<=1){
        return s;
    }
    boolean[][] dp = new boolean[len][len];
    for(int i=s.length()-2;i>=0;i--){
        int le=i;
        for(int j=i;j<s.length();j++){

            if(((j-i)<3?s.charAt(i)==s.charAt(j):s.charAt(i)==s.charAt(j)&&dp[i+1][j-1])){
                dp[i][j]=true;
                le=j;
            }else{
                dp[i][j]=false;
            }
        }
        if(maxLen<le-i){
            maxLen=le-i;
            lo=i;
        }
    }
    return s.substring(lo,lo+maxLen+1);
}

}
