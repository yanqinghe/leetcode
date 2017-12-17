//https://leetcode.com/problems/maximal-square/description/
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        //排除异常情况
        if(matrix==null||matrix.length<1||matrix[0].length<1) return 0;
        //获取当前矩阵的行列
        int m = matrix.length,n= matrix[0].length;
        //初始化二维数组
        int [][] dp = new int[m+1][n+1];
        int res = 0;
        //对矩阵进行遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1'){
                    //如果矩阵当前的元素为1，
                    //递推公式如下
                    dp[i+1][j+1]=Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j])+1;
                    //记录最大值
                    res = Math.max(dp[i+1][j+1],res);
                }else {
                    dp[i+1][j+1]=0;
                }
            }
        }
        //返回最大值的平方
        return res*res;
    }
}
