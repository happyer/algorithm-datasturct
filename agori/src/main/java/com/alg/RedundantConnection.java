package com.alg;

import java.util.*;

/**
 * Created by chengxu03 on 2021/8/5.
 */
public class RedundantConnection {


    public static void main(String[] args) {
        //[[1,2],[1,3],[2,3]]
        RedundantConnection re = new RedundantConnection();


        int[] ans = re.findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        System.out.println("ans = " + ans);
    }


    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            visited.clear();
            int v1 = edge[0];
            int v2 = edge[1];
            if (hasPath(graph, v1, v2, visited)) {
                return edge;
            }
            if (graph.get(v1) != null && !graph.get(v1).isEmpty()) {
                List<Integer> tmp = graph.get(v1);
                tmp.add(v2);
                graph.put(v1, tmp);
            } else {
                List<Integer> t = new ArrayList<>();
                t.add(v2);
                graph.put(v1, t);
            }
            if (graph.get(v2) != null && !graph.get(v2).isEmpty()) {
                List<Integer> tmp = graph.get(v2);
                tmp.add(v1);
                graph.put(v2, tmp);
            } else {
                List<Integer> t = new ArrayList<>();
                t.add(v1);
                graph.put(v2, t);
            }
        }
        return null;
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] indegree = new int[edges.length+1];
        int twoIndegreeVtx = -1;
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            indegree[dest]++;
            if (indegree[dest] == 2) twoIndegreeVtx = dest;
        }
        if (twoIndegreeVtx == -1){
           return detectCycle(edges,new int[]{-1,-1});
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            if (edges[i][1] == twoIndegreeVtx){
                int [] ds  = detectCycle(edges,edges[i]);
                if (ds == null){
                    return edges[i];
                }
            }
        }
        return new int[0];
    }


    public int[] detectCycle(int [][] edges,int [] skip){
        Integer[] fa = new Integer[edges.length+1];
        for(int i = 1; i < fa.length; i++) fa[i] = i;
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            if (src == skip[0] && dest == skip[1]) continue;
            int ps = find(fa,src);
            int pd = find(fa,dest);
            if (ps == pd) return edge;
            fa[pd] =  ps;
        }
        return null;
    }


    private void mergeDirected(Integer[] fa, int pu, int pv) {
        fa[pv] = pu;
    }


    public int[] findRedundantConnection2(int[][] edges) {
        Integer[] fa = new Integer[edges.length + 1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (fa[u] == null) fa[u] = u;
            if (fa[v] == null) fa[v] = v;
            int pv = find(fa, v);
            int pu = find(fa, u);
            if (pu == pv) {
                return edge;
            }else {
                merge(fa,pu,pv);
            }

        }
        return null;
    }

    private void merge(Integer[] fa, int pu,int pv) {
        fa[pv] = pu;
    }

    private int find(Integer[] fa, int v) {
        if (v == fa[v]) return v;
        fa[v] = find(fa, fa[v]);
        return fa[v];

    }

    private boolean hasPath(Map<Integer, List<Integer>> graph, int cur, int target, Set<Integer> visited) {

        if (cur == target) return true;
        visited.add(cur);
        if (!graph.containsKey(cur) || !graph.containsKey(target)) return false;
        for (Integer integer : graph.get(cur)) {
            if (visited.contains(integer)) continue;
            return hasPath(graph, integer, target, visited);
        }
        return false;
    }

}
