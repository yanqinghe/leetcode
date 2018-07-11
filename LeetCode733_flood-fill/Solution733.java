public class Solution733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        dfs(image,new boolean[m][n],m,n,sr,sc,newColor);
        return image;
    }
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    void dfs (int[][]image,boolean[][] dp ,int m ,int n,int i,int j,int newColor){
        dp[i][j]=true;
        int i1 = i,j1=j;
        for (int k = 0; k < 4; k++) {
            i1=i+dir[k][0];
            j1=j+dir[k][1];
            if(i1>=0&&j1>=0&&i1<m&&j1<n&&!dp[i1][j1]&&image[i][j]==image[i1][j1])
            dfs(image,dp,m,n,i1,j1,newColor);
        }
        image[i][j]=newColor;
    }
}
