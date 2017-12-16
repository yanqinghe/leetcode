
class Solution36 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] numRow = new boolean[9];
            boolean[] numRange = new boolean[9];
            boolean[] numSub = new boolean[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int numTemp = board[i][j] - '1';
                    if (numRow[numTemp])
                        return false;
                    numRow[numTemp] = true;

                }
                if (board[j][i] != '.') {
                    int numTemp = board[j][i] - '1';
                    if (numRange[numTemp])
                        return false;
                    numRange[numTemp] = true;

                }
                if (board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.') {
                    int numTemp = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] - '1';
                    if (numSub[numTemp])
                        return false;
                    numSub[numTemp] = true;
                }
            }
        }
        return true;
    }
}