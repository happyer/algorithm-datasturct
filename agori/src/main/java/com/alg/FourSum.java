package com.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {

    public static void main(String[] args) {


        int a[] = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
//        int a[] = {-1,0,1,2,-1,-4};
        fourSum(a).forEach(integers -> System.out.println("integers = " + integers));
    }

    public static List<List<Integer>> fourSum(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            data.put(nums[i], i);
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    List<Integer> tmp = new ArrayList<>();
                    int target = -nums[i] - nums[j] -nums[k];
                    if (data.containsKey(target) && data.get(target) > k) {
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(target);
                        tmp.sort((o1, o2) -> o1 - o2);
                        res.add(tmp);
                    }
                }
            }

        }
        return new ArrayList<>(res);
    }
}
