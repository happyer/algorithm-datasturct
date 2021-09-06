package com.alg;

/**
 * Created by chengxu03 on 2021/8/3.
 */
public class SurroundedRegions {


    private static int row = 0, col = 0;

    public static void solve(char[][] board) {
        row = board.length-1;
        col = board[0].length-1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || i == row || j == 0 || j == col) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O'){
                    //O-->X
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'E'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == 'X' || board[i][j] == 'E') {
            return;
        }
        board[i][j] = 'E';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
