public class Solution794 {
    public static void main(String[] args) {
        Solution794 solution794 = new Solution794();
        System.out.println(solution794.validTicTacToe(new String[]{
                "XXX", "XOO", "XOO"
        }));
    }
    public boolean validTicTacToe(String[] board) {
        int xcnt = 0,ocnt =0;
        boolean x=false,o=false;
        for (int i = 0; i < 3; i++) {
            if(board[i].equals("XXX")) x=true;
            if(board[i].equals("OOO")) o=true;
            for (int j = 0; j < 3; j++) {
                if(board[i].charAt(j)=='X') xcnt++;
                if(board[i].charAt(j)=='O') ocnt++;
            }
        }
        if(Math.abs(xcnt-ocnt)>1||ocnt==1&&xcnt==0||xcnt<ocnt)    return false;

        for (int i = 0; i <3; i++) {
            if(board[0].charAt(i)=='X'&&board[1].charAt(i)=='X'&&board[2].charAt(i)=='X'){
                x=true;
            }
            if(board[0].charAt(i)=='O'&&board[1].charAt(i)=='O'&&board[2].charAt(i)=='O'){
                o=true;
            }
        }
        if(board[0].charAt(0)=='X'&&board[1].charAt(1)=='X'&&board[2].charAt(2)=='X'){
            x=true;
        }
        if(board[0].charAt(2)=='X'&&board[1].charAt(1)=='X'&&board[2].charAt(0)=='X'){
            x=true;
        }
        if(board[0].charAt(0)=='O'&&board[1].charAt(1)=='O'&&board[2].charAt(2)=='O'){
            o=true;
        }
        if(board[0].charAt(2)=='O'&&board[1].charAt(1)=='O'&&board[2].charAt(0)=='O'){
            o=true;
        }
        if(x&&ocnt>=xcnt) return false;
        if(o&&xcnt!=ocnt) return false;
        return true;
    }
}
