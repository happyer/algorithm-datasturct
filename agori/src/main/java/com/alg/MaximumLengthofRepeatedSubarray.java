package com.alg;

public class MaximumLengthofRepeatedSubarray {

    public int findLength(int[] A, int[] B) {

        int aLen = A.length;
        int bLen = B.length;

        int[][] dp = new int[aLen][bLen];

        int res = 0;
        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                dp[i][j] = A[i-1] == B[j-1] ? dp[i - 1][j - 1] + 1 : 0;
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }

}
