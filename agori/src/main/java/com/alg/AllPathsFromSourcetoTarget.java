//package com.alg;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by chengxu03 on 2021/7/28.
// */
//public class AllPathsFromSourcetoTarget {
//
//
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//
//
//        List<List<Integer>> parent  = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        Set<Integer> visited = new HashSet<>();
//        path.add(0);
//        visited.add(0);
//        doDfs(graph,0,visited,path,parent);
//        return parent;
//    }
//
//    private void doDfs(int[][] graph, int i, Set<Integer> visited, List<Integer> path, List<List<Integer>> parent) {
//
//        if (i == graph.length-1){
//            parent.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i1 : graph[i]) {
//            if (!visited.contains(i1)){
//                path.add(i1);
//                visited.add(i1);
//                doDfs(graph,i1,visited,path,parent);
//                visited.remove(i1);
//                path.remove(path.size()-1);
//            }
//        }
//
//
//    }
//}
