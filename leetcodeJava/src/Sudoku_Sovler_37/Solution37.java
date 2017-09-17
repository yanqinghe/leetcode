package Sudoku_Sovler_37;

public class Solution37 {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length !=9)
            return;
        helper(board,0,0);
    }
    private boolean helper(char[][] board,int i,int j){
        if(j>=9){
            //当j超过列数的时候，进入下一行
            return helper(board,i+1,0);
        }
        if(i==9){
            //完成操作返回
            return true;
        }
        if(board[i][j]!='.'){
            //如果当前填充的单元格有初始值，那么跳到下一个单元格
            return helper(board,i,j+1);

        }else {
            for(int m = 1;m<=9;m++){
                board[i][j]=(char)(m+'0');
                if(isValid(board,i,j)) {
//                    return helper(board, i, j++);
                    if (helper(board, i, j+1))
                        return true;
                }
                board[i][j]='.';
            }
        }
        return false;
    }
    private boolean isValid(char[][] board,int i,int j){
        //判断当前单元格填入的数字在是否满足行和列的两种要求
        for(int m=0;m<9;m++){
            if((m!=j&&board[i][m]==board[i][j])||(m!=i&&board[m][j]==board[i][j])){
                return false;
            }
        }
//        判断当前单元格填入的数字是否满足单元格内的要求
        for(int r=i/3*3;r<i/3*3+3;r++){
            for(int c =j/3*3;c<j/3*3+3;c++){
                if((r!=i || c!=j) && board[r][c]==board[i][j])
                    return false;
            }
        }
        return true;
    }
}

