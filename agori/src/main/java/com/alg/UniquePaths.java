package com.alg;

public class UniquePaths {




    public int uniquePaths(int m, int n) {
        int [][] map = new int[m][n];
        //init
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }

        for (int k = 1; k < m; k++) {
            for (int l = 1; l < n; l++) {
                map[k][l] = map[k - 1][l] + map[k][l - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}
