package LeetCode_Contest56;

public class Solution3 {
    public static void main(String[] args) {
        int[] A = {0,1,1,1,1};
        int[] B = {1,0,1,0,1};
        Solution3 solution3 = new Solution3();
        int res= solution3.findLength(B,A);
        System.out.println(res);
    }
    public int findLength(int[] A, int[] B) {
        int alen = A.length;
        int blen = B.length;
        int[][] dp = new int[alen+1][blen+1];
        int max = 0;
        for (int i = 1; i <=alen ; i++) {
            for (int j = 1; j <=blen ; j++) {
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max= Math.max(dp[i][j],max);
                }else {
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }
}
