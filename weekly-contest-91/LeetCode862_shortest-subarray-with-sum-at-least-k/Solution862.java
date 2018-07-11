public class Solution862 {
    public static void main(String[] args) {
        Solution862 solution862 = new Solution862();
        System.out.println(solution862.shortestSubarray(new int[]{17,85,93,-45,-21},150)==2);//2
        System.out.println(solution862.shortestSubarray(new int[]{2,-1,2},3)==3);//3
        System.out.println(solution862.shortestSubarray(new int[]{1,2},4)==-1);//-1
        System.out.println(solution862.shortestSubarray(new int[]{1},1)==1);//1
        System.out.println(solution862.shortestSubarray(new int[]{84,-37,32,40,95},167)==3);//167
        System.out.println(solution862.shortestSubarray(new int[]{45,95,97,-34,-42},21)==3);//167




    }
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        int[][]dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[0][i]=A[i];
            if(dp[0][i]>=K) return 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len-i; j++) {
                dp[i][j]=dp[0][j]+dp[i-1][j+1];
                if(dp[i][j]>=K)
                    return i+1;
            }
        }
        return -1;

    }

}
