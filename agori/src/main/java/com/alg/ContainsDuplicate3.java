package com.alg;

import java.util.TreeSet;

/**
 * Created by chauncy on 2018/7/23.
 */
public class ContainsDuplicate3 {


    /**
     * 使用一个K 个数的窗口 寻找小于他的组大,大于他的最小,如果纯在就返回 否则就false
     * @param nums
     * @param k
     * @param t
     * @return
     */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;

        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            Integer floor = set.floor(nums[i]);
            Integer cell = set.ceiling(nums[i]);
            if ((floor != null && nums[i] <= floor + t) ||
                    cell != null && nums[i] >= cell - t) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }

        }
        return false;
    }
}
