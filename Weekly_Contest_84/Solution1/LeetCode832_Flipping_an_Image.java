import java.util.Arrays;

public class LeetCode832_Flipping_an_Image {
    public static void main(String[] args) {
        LeetCode832_Flipping_an_Image leetCode832_flipping_an_image = new LeetCode832_Flipping_an_Image();
        System.out.println(leetCode832_flipping_an_image.flipAndInvertImage(new int[][]{
                {1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}
        }));
    }
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp= A[i][j];
                A[i][j]=A[i][n-j-1];
                A[i][n-j-1]=temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                    A[i][j]=A[i][j]==1?0:1;
            }
        }
        return A;
    }

}
