package com.alg;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/7/18.
 */
public class RemoveZero {

    private int cnt = 0;

    public void moveZeroes(int[] nums) {
        int currentIndex = removeElement(nums, 0);
        for (int i = currentIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];

            }
        }
        return index;
    }


    public static void main(String[] args) {
        int a[] = {0, 1, 0, 3, 1, 2};
        RemoveZero removeZero = new RemoveZero();
        removeZero.moveZeroes(a);
        for (int i = 0; i < a.length; i++) {

            out.println("i=" + i + "val=" + a[i]);
        }

    }
}
