package com.alg;

public class UniquePaths2th {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] map = new int[m][n];
        //init
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] ==1){
                map[i][0] = 0;
                //First row, once obstacle found, the rest are blocked.because this row not pass
                break;
            }else {
                map[i][0] = 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] ==1 ){
                map[0][j] = 0;
                break;
            }else {
                map[0][j] = 1;
            }
        }
        for (int k = 1; k < m; k++) {
            for (int l = 1; l < n; l++) {
                if (obstacleGrid[k][l] ==1){
                    map[k][l] = 0;
                }else {
                    map[k][l] = map[k - 1][l] + map[k][l - 1];
                }
            }
        }
        return map[m - 1][n - 1];

    }

}
