package com.alg;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/7/19.
 */
public class TrappingRainWater {


    public static int trap(int height[]) {

        int max = Integer.MIN_VALUE;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            left[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            right[i] = max;
        }

        int vol = 0;

        for (int i = 0; i < height.length; i++) {
            vol = vol + (Math.min(left[i], right[i]) - height[i]);
        }

        return vol;

    }


    public static void main(String[] args) {
//        int a[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int a[] = {1,8,6,2,5,4,8,3,7};
        int r = trap(a);
        out.println(r);

    }


}
