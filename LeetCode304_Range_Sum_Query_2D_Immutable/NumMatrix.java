/**
 * Status: Time Limit Exceeded
 */
public class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        if(matrix==null||matrix.length<1||matrix[0].length<1) return;
        int m = matrix.length,n = matrix[0].length;
        sumMatrix = new int[m][n];
        sumMatrix[0][0]=matrix[0][0];
        //首先计算数组

        for (int i=1;i<m;i++){
            sumMatrix[i][0]=sumMatrix[i-1][0]+matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            sumMatrix[0][i]=sumMatrix[0][i-1]+matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sumMatrix[i][j]=sumMatrix[i-1][j]+sumMatrix[i][j-1]-sumMatrix[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = sumMatrix[row2][col2];
        if(row1!=0){
            sum-=sumMatrix[row1-1][col2];
        }
        if(col1!=0){
            sum-=sumMatrix[row2][col1-1];
        }
        if(col1!=0&&row1!=0){
            sum+=sumMatrix[row1-1][col1-1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */