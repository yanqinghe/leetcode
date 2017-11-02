package LeetCode79_Word_Search;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] dp = new boolean[m][n];
                    dp[i][j] = true;
                    help(board, word, dp, 1, i, j);
                    if (result) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    boolean result = false;

    private void help(char[][] board, String word, boolean[][] dp, int index, int i, int j) {
        if (index == word.length()) {
            result = true;
        } else {
            if (result == true) {
                return;
            }
            if (i < board.length - 1 && board[i + 1][j] == word.charAt(index) && !dp[i + 1][j]) {
                dp[i + 1][j] = true;
                help(board, word, dp, index + 1, i + 1, j);
                dp[i + 1][j] = false;
            }
            if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(index) && !dp[i][j + 1]) {
                dp[i][j + 1] = true;
                help(board, word, dp, index + 1, i, j + 1);
                dp[i][j + 1] = false;
            }
            if (i > 0 && board[i - 1][j] == word.charAt(index) && !dp[i - 1][j]) {
                dp[i - 1][j] = true;
                help(board, word, dp, index + 1, i - 1, j);
                dp[i - 1][j] = false;
            }
            if (j > 0 && board[i][j - 1] == word.charAt(index) && !dp[i][j - 1]) {
                dp[i][j - 1] = true;
                help(board, word, dp, index + 1, i, j - 1);
                dp[i][j - 1] = false;
            }
        }
    }
}
