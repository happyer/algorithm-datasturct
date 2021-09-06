package com.alg;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by chengxu03 on 2021/8/3.
 */
public class WaterAndJugProblem {


    public static void main(String[] args) {
        WaterAndJugProblem w = new WaterAndJugProblem();


        //104579
        //104593
        //12444
        boolean an = w.canMeasureWater3(104579, 104593, 12444);
        System.out.println("an = " + an);
    }


    private boolean isAns;


    public boolean canMeasureWater(int x, int y, int z) {


        if (x + y < z) return false;


        int[] directions = new int[]{x, -x, y, -y};
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == z) {
                return true;
            }
            for (int direction : directions) {
                int total = cur + direction;
                if (total == z) return true;
                if (total > x + y || total < 0) continue;
                if (!visited.contains(total)) {
                    visited.add(total);
                    queue.offer(total);
                }

            }

        }
        return false;

    }

    public boolean canMeasureWater3(int x, int y, int z) {


        if (x + y < z) return false;

        int[] directions = new int[]{x, -x, y, -y};
        Set<Integer> visited = new HashSet<>();
        dfs(visited, directions, 0, z, x + y);
        return isAns;

    }


    private void dfs(Set<Integer> visited, int[] directions, int i, int z, int g) {
        if (i == z) {
            isAns = true;
            return;
        }
        for (int direction : directions) {
            int total = i + direction;
            if (total > g || total < 0) continue;
            if (!visited.contains(total)) {
                visited.add(i + direction);
                dfs(visited, directions, total, z, g);
            }
        }
    }
}
