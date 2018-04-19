package com.alg;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        //[2, 7, 11, 15], target = 9,
        //[0, 1].

        int a[] = {3,3};
        int[] re = twoSum(a, 6);
        for (int i : re) {
            System.out.println("i = " + i);
        }

    }



    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (data.containsKey(target - nums[i])){
                return new int[]{data.get(target-nums[i]),i};
            }
            data.put(nums[i],i);
        }

        return null;
    }
}
