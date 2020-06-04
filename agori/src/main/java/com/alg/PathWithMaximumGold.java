package com.alg;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/3
 */
public class PathWithMaximumGold {

    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 7, 8}, {0, 9, 0}};
        System.out.println(" = " + new PathWithMaximumGold().getMaximumGold(grid));
    }


    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backDfs(grid, i, j, 0);
            }
        }
        return max;
    }


    static int max = Integer.MIN_VALUE;

    public void backDfs(int[][] grid, int i, int j, int sum) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == 0) {
            max = Math.max(max, sum);
            return;
        }
        int g = grid[i][j];
        sum += g;
        grid[i][j] = 0;
        backDfs(grid, i - 1, j, sum);
        backDfs(grid, i + 1, j, sum);
        backDfs(grid, i, j - 1, sum);
        backDfs(grid, i, j + 1, sum);
        grid[i][j] = g;

    }


}
