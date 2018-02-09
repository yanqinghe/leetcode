
public class Solution733 {
    public static void main(String[] args) {
        int[][] a= {{0,0,0},{0,0,0}};
        Solution733 solution733 = new Solution733();
        solution733.floodFill(a,0,0,2);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean [][]dp = new boolean[image.length][image[0].length];
        help(image,sr,sc,newColor,image[sr][sc],dp);
        return image;
    }
    void help(int[][] image, int i, int j, int newColor,int oldColor,boolean[][] dp){
        if(dp[i][j]) return;
        if(image[i][j]==oldColor) {
            image[i][j]=newColor;
            dp[i][j] =true;
            if(i>0) help(image,i-1,j,newColor,oldColor,dp);
            if(j>0) help(image,i,j-1,newColor,oldColor,dp);
            if(i<image.length-1) help(image,i+1,j,newColor,oldColor,dp);
            if(j<image[0].length-1) help(image,i,j+1,newColor,oldColor,dp);
        }
    }


}
