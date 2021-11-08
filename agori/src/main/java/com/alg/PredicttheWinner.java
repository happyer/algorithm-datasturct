package com.alg;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chengxu03 on 2021/9/22.
 */
public class PredicttheWinner {
    private static final String BASE_VERSION = "0.7.6";


    public static void main(String[] args) {
        int[] src = new int[]{1, 5, 233, 7};
        PredicttheWinner p = new PredicttheWinner();
        boolean ans = p.predictTheWinner(src);
        System.out.println(ans);
        String v = "0.7.3";
        System.out.println(v.compareTo(BASE_VERSION));
    }

    public int play(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        for (int i = nums.length; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    int a = nums[i] - dp[i+1][j];
                    int b = nums[j] - dp[i][j - 1];
                    dp[i][j] = Math.max(a, b);
                }
            }
        }
        return dp[0][nums.length - 1];
    }


    public int play(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        int planA = nums[l] - play(nums, l + 1, r);
        int planB = nums[r] - play(nums, l, r - 1);
        return Math.max(planA, planB);
    }


    public int dfs(int[] nums, int l, int r, boolean isPlayer) {
        if (l == r) {
            return isPlayer ? nums[l] : -nums[l];
        }
        if (isPlayer) {
            return Math.max(
                    dfs(nums, l + 1, r, !isPlayer) + nums[l],
                    dfs(nums, l, r - 1, !isPlayer) + nums[r]);
        } else {
            return Math.min(
                    dfs(nums, l + 1, r, !isPlayer) - nums[l],
                    dfs(nums, l, r - 1, !isPlayer) - nums[r]
            );
        }
    }


    public boolean predictTheWinner(int[] nums) {

        Deque<Integer> deque = new LinkedList();
        for (int num : nums) {
            deque.offer(num);
        }

        int play1 = 0;
        int play2 = 0;
        boolean isFirstDone = false;
        while (!deque.isEmpty()) {
            int first = deque.peekFirst();
            int end = deque.peekLast();
            int max = 0;
            if (first >= end) {
                max = first;
                deque.pollFirst();
            } else {
                max = end;
                deque.pollLast();
            }
            if (!isFirstDone) {
                play1 += max;
                isFirstDone = true;
            } else {
                play2 += max;
                isFirstDone = false;
            }
        }
        return play1 >= play2;

    }
}
