package LeetCode48_Rotate;

public class Solution48 {
    public static void main(String[] args) {
        int[][] data = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution48 solution48 = new Solution48();
        solution48.rotate(data);
        return;
    }
    public void rotate(int[][] matrix) {

        int length = matrix.length;
        int iMax = length>>1;
        for(int n=0;n<=iMax;n++){
            int l = length-(n<<1);
            for(int i=0;i<l-1;i++){
                //将第一行的数据保留下来
                int temp=matrix[n][length-1-n-i];
                //将左边旋转移到上边
                matrix[n][length-1-n-i]=matrix[i+n][n];
                //将底边转移到左边
                matrix[i+n][n]=matrix[length-1-n][i+n];
                //将右边转移到底边
                matrix[length-1-n][i+n]=matrix[length-1-n-i][matrix.length-1-n];
                //将上边的值转移到右边
                matrix[length-1-n-i][length-1-n]=temp;
            }
         }
    }

}
