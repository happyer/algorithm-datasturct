package com.alg;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chengxu03 on 2021/8/10.
 */
public class EscapeLargeMaze {


    private boolean isAns = false;

    private int max = 1000000;


    public static void main(String[] args) {
        //blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]

        int[][] blocked = new int[][]{{0, 1}, {1, 0}};
        int[] source = new int[]{0, 0};
        int[] target = new int[]{0, 2};
        EscapeLargeMaze escapeLargeMaze = new EscapeLargeMaze();
        boolean an = escapeLargeMaze.isEscapePossible(blocked, source, target);
        System.out.println("an = " + an);

    }


    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {


        help(blocked, source[0], source[1], target[0], target[1]);

        Set<String> block = new HashSet<>();
        for (int[] ints : blocked) {
            block.add(ints[0] + "," + ints[1]);
        }


        return dfs(source, target,source, block, new HashSet<>()) && dfs(target, source,source, block, new HashSet<>());


//        return isAns;
    }

    private boolean dfs(int[] cur, int[] target,int [] source, Set<String> block, HashSet<Object> visit) {
        if (cur[0] == target[0] && cur[1] == target[1]) {
            return true;
        }
        if ((Math.abs(cur[0] - source[0]) + Math.abs(cur[1] - source[1])) > 200) {
            return true;
        }
        for (int[] ints : new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}}) {
            int i = cur[0] + ints[0];
            int j = cur[1] + ints[1];
            String key = i + "," + j;
            if (i > 0 && i < 1000000 && j > 0 && j < 1000000) {
                if (!visit.contains(key) && !block.contains(key)) {
                    visit.add(key);
                    if (dfs(new int[]{i, j}, target,source, block, visit)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private void help(int[][] blocked, int x, int y, int tx, int ty) {
        if (x == tx && y == ty) {
            isAns = true;
            return;
        }
        if (x > max || y > max || x < 0 || y < 0) {
            return;
        }
        for (int[] ints : blocked) {
            if (ints[0] == x && ints[1] == y) {
                return;
            }
        }
        help(blocked, x + 1, y, tx, ty);
        help(blocked, x - 1, y, tx, ty);
        help(blocked, x, y + 1, tx, ty);
        help(blocked, x, y - 1, tx, ty);

    }
}
