package com.alg;

import java.util.*;

/**
 * Created by chengxu03 on 2021/8/19.
 * <p>
 * rolling hash
 */
public class LongestCommonSubpath {


    private long base = 5;


    public static void main(String[] args) {
        //[[0,1,2,3,4],
        //                       [2,3,4],
        //                       [4,0,1,2,3]]


        LongestCommonSubpath l = new LongestCommonSubpath();


        int[][] paths = new int[][]{{0, 1, 2, 3, 4}, {2, 3, 4}, {4, 0, 1, 2, 3}};
        int res = l.longestCommonSubpath(5, paths);
        System.out.println("res = " + res);
    }


    public int longestCommonSubpath(int n, int[][] paths) {
        int left = 0, right = getMin(paths);
        while (left <= right) {
            int len = left + (right - left) / 2;
            if (checkOk(paths, len)) {
                left = len+1;
            } else {
                right = right - 1;
            }
        }
        return left;
    }

    private boolean checkOk(int[][] paths, int len) {


        Map<Long, Integer> count = new HashMap<>();


        long head = 1;
        for (int i = 0; i < len; i++) {
            head = head * base;
        }

        for (int[] nums : paths) {
            Set<Long> exist = new HashSet<>();


            long hash = 0;
            for (int i = 0; i < len; i++) {
                hash = hash * base + nums[i];
            }
            if (!exist.contains(hash)) exist.add(hash);
            for (int j = len; j < nums.length; j++) {
                hash = hash * base + nums[j] - nums[j - len] * head;
                if (!exist.contains(hash)) {
                    exist.add(hash);
                    if (!count.containsKey(hash)) {
                        count.put(hash, 1);
                    } else {
                        count.put(hash, count.get(hash) + 1);
                    }
                }
            }



        }
        for (Map.Entry<Long, Integer> longIntegerEntry : count.entrySet()) {
            if (longIntegerEntry.getValue().equals(paths.length)) {
                return true;
            }
        }

        return false;
    }


    public int longestCommonSubpath2(int n, int[][] paths) {
        int left = 1, right = getMin(paths);
        Random rand = new Random();
        long base = 135721;//100000 + rand.nextInt(1000000-100000+1);
        long mod = Long.MAX_VALUE;
        long muti = 0;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            muti = pow(base, mid, mod);
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < paths.length; i++) {
                long hash = 0;
                Set<Long> tmp = new HashSet<>();
                for (int j = 0; j < mid; j++) {
                    hash = (hash * base + paths[i][j]) % mod;
                }
                if (i == 0 || set.contains(hash)) {
                    tmp.add(hash);
                }

                for (int j = mid; j < paths[i].length; j++) {
                    hash = (hash * base + paths[i][j] - muti * paths[i][j - mid]) % mod;
                    if (i == 0 || set.contains(hash)) {
                        tmp.add(hash);
                    }
                }
                set = tmp;
                if (set.isEmpty()) {
                    break;
                }
            }
            if (set.isEmpty()) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    int getMin(int[][] paths) {
        int min = paths[0].length;
        for (int[] path : paths) {
            min = Math.min(path.length, min);
        }
        return min;
    }

    long pow(long base, long n, long mod) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = (res * base) % mod;
        }
        return res;
    }


}
