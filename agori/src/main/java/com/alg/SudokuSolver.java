package com.alg;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        doSolver(board, 0, 0);
    }

    private boolean doSolver(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolver(board, i, j + 1)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol =
            (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num ||
                board[blkrow + i / 3][blkcol + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i =0 ; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (!isValid(board,i,j,board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

}
