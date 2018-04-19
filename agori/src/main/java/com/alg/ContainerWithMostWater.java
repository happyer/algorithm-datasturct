package com.alg;

/**
 * Created by chauncy on 2018/7/20.
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        if (height.length == 0) return 0;
        if (height.length == 1) return height[0];
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {


        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("arr = " +maxArea(arr));
    }
}
