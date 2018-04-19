package com.alg;

import java.util.PriorityQueue;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/7/19.
 */
public class TrappingRainWater2 {

    public static int trapRainWater(int[][] heightMap) {


        if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    priorityQueue.offer(new int[]{i, j, heightMap[i][j]});
                }
            }
        }

        int res = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!priorityQueue.isEmpty()) {
            int[] cell = priorityQueue.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, cell[2] - heightMap[x][y]);
                    priorityQueue.offer(new int[]{x, y, Math.max(cell[2], heightMap[x][y])});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int a[][] = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };

        int r  = trapRainWater(a);
        out.println(r);
    }
}
