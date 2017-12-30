public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length<1 || matrix[0].length<1){
            return false;
        }
        int i = matrix.length-1;//横坐标
        int j = 0;//纵坐标
        boolean isEnd = false;
        while (!isEnd){
            if(target==matrix[i][j]) isEnd = true;
            else if(target<matrix[i][j]){
                i--;
                if(i<0) return isEnd;
            }else if(target>matrix[i][j]){
                j++;
                if(j==matrix[0].length) return isEnd;
            }
        }
        return isEnd;
    }
}
