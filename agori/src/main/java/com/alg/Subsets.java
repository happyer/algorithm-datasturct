package com.alg;

import com.alg.MaxPointOnLine.Line;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/4
 */
public class Subsets {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),res);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> temp, List<List<Integer>> res) {
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            dfs(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
