package com.alg;

import java.util.*;

/**
 * Created by chengxu03 on 2021/8/12.
 */
public class FrogPositionAfterTSeconds {


    private List<Set<Integer>> adj = new ArrayList<>();
    private boolean isFound = false;
    private double pro;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        for (int i = 0; i <= n+1; i++) {
            adj.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(adj, -1, 1, target, t, 0, 1.0d);
        return pro;
    }


    private void dfs(List<Set<Integer>> graph, int prev, int cur, int target, int maxTime, int time, double p) {
        if (!isFound && time <= maxTime) {
            graph.get(cur).remove(prev);
            if (cur == target && time == maxTime) {
                isFound = true;
                pro = p;
                return;
            } else {
                if (graph.get(cur).isEmpty()) {
                    //no
                    dfs(graph, cur, cur, target, maxTime, time + 1, p);
                } else {
                    p = p / (double) graph.get(cur).size();
                    for (Integer integer : graph.get(cur)) {
                        dfs(graph,cur,integer,target,maxTime,time+1,p);
                    }
                }
            }

        }
    }

}
