package com.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/3
 */
public class Permutations {


    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean vis[]=new boolean[nums.length];

        //array to store the visited numbers
        int arr[]=new int[nums.length];
        permuteDfs(nums,0,nums.length,arr,vis);

        return ans.stream().distinct().collect(Collectors.toList());

    }


    public void permuteDfs(int[] nums, int current, int n, int arr[], boolean vis[]) {

        if (current > n) {
            return;
        }
        if (current == n) {
            List<Integer> l = new ArrayList<>();
            for (Integer a : arr) {
                l.add(a);
            }
            ans.add(l);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                arr[current] = nums[i];
                permuteDfs(nums, current + 1, n, arr, vis);
                vis[i] = false;
            }
        }
        return;
    }

}
