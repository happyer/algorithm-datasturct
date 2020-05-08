package com.alg;

public class UniquePathsThree {

    int startRow, startCol;

    int targetRow, targetCol;

    int[][] grid;

    int ans = 0;

    int[] directRow = new int[]{0, -1, 0, 1};
    int[] directCol = new int[]{1, 0, -1, 0};

    int row;
    int col;

    public int uniquePathsIII(int[][] grid) {

        this.grid = grid;
        row = grid.length;
        col = grid[0].length;

        int todo = 0;

        //look up start target
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
                if (grid[i][j] == 2) {
                    targetRow = i;
                    targetCol = j;
                }
                if (grid[i][j] != -1) {
                    todo++;
                }

            }
        }

        dfs(startRow, startCol, todo);
        return ans;

    }

    private void dfs(int startRow, int startCol, int todo) {
        todo--;
        if (todo < 0) {
            return;
        }
        if (startRow == targetRow && startCol == targetCol) {
            if (todo == 0) {
                ans++;
                return;
            }
        }

        grid[startRow][startCol] = 3;
        for (int k = 0; k < 4; k++) {
            int newRow = startRow + directRow[k];
            int newCol = startCol + directCol[k];
            if (0 <= newRow && newRow < row && 0 <= newCol && newCol < col) {
                if (grid[newRow][newCol] % 2 == 0) {
                    dfs(newRow, newCol, todo);
                }
            }
        }
        //because run at here,this startRow startCol is can  walk over
        grid[startRow][startCol] = 0;
    }
}
