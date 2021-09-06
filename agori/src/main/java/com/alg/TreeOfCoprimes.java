package com.alg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chengxu03 on 2021/8/13.
 */
public class TreeOfCoprimes {


    private List<Set<Integer>> adj = new ArrayList();


    private boolean[][] cop = new boolean[51][51];
    private int[] ret;

    public static void main(String[] args) {
        //nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
//        int[] nums = new int[]{2, 3, 3, 2};
//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}};

        //nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]

        int[] nums = new int[]{5,6,10,2,3,6,15};
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 3},{1,4},{2,5},{2,6}};

        TreeOfCoprimes treeOfCoprimes = new TreeOfCoprimes();

        int [] ans  =  treeOfCoprimes.getCoprimes(nums,edges);
        for (int an : ans) {
            System.out.println("an = " + an);
        }
    }


    public int[] getCoprimes(int[] nums, int[][] edges) {
        ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    cop[i][j] = true;
                }
            }
        }
        dfs(0, new ArrayList<>(), nums,new boolean[nums.length+1]);
        return ret;
    }


    private void dfs(int cur, List<Integer> path, int[] nums,boolean [] visit) {
        visit[cur] = true;
        boolean isFlag = false;
        for (int i = path.size() - 1; i >= 0; i--) {
            int lastNode = path.get(i);
            int curVal = nums[cur];
            int lastNodeVal = nums[lastNode];
            if (cop[curVal][lastNodeVal]) {
                ret[cur] = lastNode;
                isFlag = true;
                break;
            }
        }


        if (!isFlag) {
            ret[cur] = -1;
        }
        for (Integer integer : adj.get(cur)) {
            if (!visit[integer]){
                path.add(cur);
                dfs(integer, path, nums,visit);
                path.remove(path.size() - 1);
            }
        }
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }


}
