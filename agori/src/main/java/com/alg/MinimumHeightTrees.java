package com.alg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chengxu03 on 2021/8/12.
 */
public class MinimumHeightTrees {




    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        List<Set<Integer>> nei = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            nei.add(new HashSet<>());
        }


        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            nei.get(u).add(v);
            nei.get(v).add(u);
        }

        List<Integer> leafs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nei.get(i).size() == 1){
                leafs.add(i);
            }
        }


        int remainNode = n;
        while (remainNode > 2) {
            remainNode -= leafs.size();
            List<Integer> newLeaf = new ArrayList<>();

            for (Integer integer : leafs) {
                int ne = nei.get(integer).iterator().next();
                nei.get(ne).remove(integer);
                if (nei.get(ne).size() == 1) {
                    newLeaf.add(ne);
                }
            }
            leafs = newLeaf;
        }

        return leafs;

    }

}
