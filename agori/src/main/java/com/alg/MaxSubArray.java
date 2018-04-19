package com.alg;

public class MaxSubArray {

    public static void main(String[] args) {

        int[] a = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
       int res=  maxSubArray(a);
        System.out.println("res = " + res);
    }

    public static int maxSubArray(int[] nums) {

        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        for (int i : dp) {
            if (i>res){
                res = i;
            }
        }

        return res;
    }
}
