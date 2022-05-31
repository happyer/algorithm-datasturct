package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengxu03 on 2021/7/30.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        char[][] bor = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bor[i][j] = '.';
            }
        }
        help(n, 0, bor, ans);
        return ans;
    }

    private void help(int n, int row, char[][] bor, List<List<String>> ans) {
        if (n == row) {
            ans.add(build(bor));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canPut(bor, row, i)) {
                bor[row][i] = 'Q';
                help(n, row + 1, bor, ans);
                bor[row][i] = '.';
            }
        }


    }

    private boolean canPut(char[][] bor, int row, int col) {


        //check all row

        for (int i = 0; i < row; i++) {
            if (bor[i][col] == 'Q') {
                return false;
            }
        }

        //check 45 degree
        for (int i = row-1, j = col+1; i >= 0 && j < bor.length; j++, i--) {
            if (bor[i][j] == 'Q'){
                return false;
            }
        }

        //check 135degree
        //check for 135 positions
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (bor[i][j] == 'Q') {
                return false;
            }
        }


        return true;
    }

    private List<String> build(char[][] bor) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < bor.length; i++) {
            path.add(new String(bor[i]));
        }
        return path;
    }
}
