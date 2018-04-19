package com.alg;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * Created by chauncy on 2018/7/18.
 */
public class RemoveDumplicate {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;

    }

    public static void main(String[] args) {

        int a[] = {3,2,2,3};
//        int a[] = {1, 2};


//        int r = removeDuplicates2(a);
//        out.println(r);
//        for (int i = 0; i < a.length; i++) {
//            out.println("i=" + i + "v=" + a[i]);
//        }
        int r = removeElement(a,3);
        System.out.println("r = " + r);;
    }

    public static int removeDuplicates2(int[] nums) {

        if (nums.length == 0)
            return 0;
        int index = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[index] == nums[i]) {
                i++;
            } else {
                nums[index + 1] = nums[i];
                index++;
                i++;
            }
        }
        return index;

    }

    public static  int removeElement(int[] nums, int val) {

        if (nums.length == 0)
            return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[index]= nums[i];
                index++;
            }
        }
        return index;

    }


    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return 0;
    }

}
