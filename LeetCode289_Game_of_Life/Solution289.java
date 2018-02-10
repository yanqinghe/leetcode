public class Solution289{

    public static void main(String[] args) {
        Solution289 solution289 = new Solution289();
        solution289.gameOfLife(new int[][]{
            {1,1},
            {1,0}
        });
    }

    private static final  int DEAD_CELL =0;
    private static final  int LIVE_CELL =1;
    private static final  int LIVE_CELL_DEAD =2;
    private static final  int DEAD_CELL_LIVE =3;
    public void gameOfLife(int[][] board) {
        if(board==null||board.length<1||board[0].length<1) return;
        int m = board.length,n = board[0].length;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                board[i][j] = judgeCell(i, j, board);
            }
        }
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]==DEAD_CELL_LIVE) board[i][j]=1;
                if(board[i][j]==LIVE_CELL_DEAD) board[i][j]=0;
            }
        }
    }
    int judgeCell(int row,int col,int[][] board){
        int count=0;
        //首先统计附近八个单元格内的细胞存活情况
        for(int i = Math.max(0,row-1);i<Math.min(board.length, row+2);i++){
            for(int j =Math.max(0,col-1);j<Math.min(board[0].length, col+2);j++){
                //跳过中心单元格
                if(i==row&&j==col) continue;
                //如果单元格附近有存活情况，统计        
                if(board[i][j]==1||board[i][j]==2) 
                count++;
            }
        }
        if(board[row][col]==LIVE_CELL){
          //任何活细胞如果活邻居为2个或3个，则继续活
            if(count==3||count==2) return LIVE_CELL;
            //任何活细胞如果活邻居少于2个，则死掉。
            //任何活细胞如果活邻居大于3个，则死掉。
            return LIVE_CELL_DEAD;
        }else{
             //任何死细胞如果活邻居正好是3个，则活过来。
            if(count==3) return DEAD_CELL_LIVE;
            return DEAD_CELL;
        }
    }
}