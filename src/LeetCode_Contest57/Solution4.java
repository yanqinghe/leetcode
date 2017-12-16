
public class CandyCrush {
    public static void main(String[] args) {
        CandyCrush candyCrush = new CandyCrush();
        int [][] b = {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
        candyCrush.candyCrush(b);
    }
    public int[][] candyCrush(int[][] board) {
        int m  = board.length;
        int n  = board[0].length;
        int[][][] dp  = new int[m][n][3];
        boolean is = false;
        for (int i = m-1; i >=0 ; i--) {
            for (int j = 0; j < n; j++) {
                if(j==0){
                    dp[i][j][0]=1;
                }else if(board[i][j]==board[i][j-1]&&board[i][j]!=0){
                    dp[i][j][0]=dp[i][j-1][0]+1;
                }else {
                    if(dp[i][j-1][0]>=3){
                        is=true;
                        int count = dp[i][j-1][0];
                        while (count>0){
                            dp[i][j-count][2]=1;
                            count--;
                        }
                    }
                    dp[i][j][0]=1;
                }
                if(j==n-1){
                    if(dp[i][n-1][0]>=3){
                        is=true;
                        int count = dp[i][n-1][0];
                        while (count>0){
                            dp[i][n-count][2]=1;
                            count--;
                        }
                    }
                }
                if(i==m-1){
                    dp[i][j][1]=1;
                }else if(board[i][j]==board[i+1][j]&&board[i][j]!=0){
                    dp[i][j][1]=dp[i+1][j][1]+1;
                }else {
                    if(dp[i+1][j][1]>=3){
                        is=true;
                        int count = dp[i+1][j][1];
                        while (count>0){
                            dp[i+count][j][2]=1;
                            count--;
                        }
                    }
                    dp[i][j][1]=1;
                }
                if(i==0){
                    if(dp[0][j][1]>=3){
                        is=true;
                        int count = dp[0][j][1];
                        while (count>0){
                            dp[count-1][j][2]=1;
                            count--;
                        }
                    }
                }
            }
        }
        if(!is) return board;
        for (int j = 0; j <n ; j++) {
            int i =m-1;
            int count = i;
            while (i>=0){
                if(dp[i][j][2]==1){
                    i--;
                    continue;
                }else {
                    board[count][j]=board[i][j];
                    i--;
                    count--;
                }
            }
            while (count>=0){
                board[count][j]=0;
                count--;
            }
        }
        candyCrush(board);
        return board;
    }
}
