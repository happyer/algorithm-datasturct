package com.alg;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * Created by chengxu03 on 2021/8/4.
 */
public class TreeAncestor {

    private int n;
    private int[] parent;
    private int length;


    private int[][] dp;


    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println("treeAncestor3.1--1 = " + treeAncestor.getKthAncestor(3, 1));
        System.out.println("treeAncestor5.2--0 = " + treeAncestor.getKthAncestor(5, 2));
        System.out.println("treeAncestor6.3--(-1) = " + treeAncestor.getKthAncestor(6, 3));


    }


    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;
        this.length = parent.length;
        //计算level


        int log = (int) ((Math.log(parent.length) / Math.log(2)) + 1);
        dp = new int[n][log];
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }
        for (int i = 1; i < log; i++)
            for (int j = 0; j < n; j++) {
                if (dp[j][i - 1] == -1) {
                    dp[j][i] = -1;
                } else {
                    dp[j][i] = dp[dp[j][i - 1]][i - 1];
                }
            }

    }


    private int ans;

    public int getKthAncestor(int node, int k) {
//        if (node > length) return -1;
//        dfs(parent, node, k);
//        return ans;

        if (node == -1) return -1;
        int step = (int) (Math.log(k) / Math.log(2));
        if (1 << step == k) return dp[node][step];
        return getKthAncestor(dp[node][step], k - (1 << step));


    }

    private void dfs(int[] parent, int node, int k) {
        if (k == 0) {
            ans = node;
            return;
        }
        if (node < 0 && k > 0) {
            ans = -1;
            return;
        }
        int cur = parent[node];
        k--;
        dfs(parent, cur, k);

    }


}
