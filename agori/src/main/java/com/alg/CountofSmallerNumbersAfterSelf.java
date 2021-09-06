package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengxu03 on 2021/8/25.
 */
public class CountofSmallerNumbersAfterSelf {


    public static class ValueIndex {
        int val;
        int idx;
        public ValueIndex(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        ValueIndex[] val = new ValueIndex[nums.length];
        for (int i = 0; i < nums.length; i++) {
            val[i] = new ValueIndex(nums[i], i);
        }
        int[] ans = new int[nums.length];
        help(val, 0, val.length - 1, ans);
        List<Integer> a = new ArrayList<>();
        for (int an : ans) {
            a.add(an);
        }
        return a;
    }

    private void help(ValueIndex[] val, int start, int end, int[] ans) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        help(val, start, mid, ans);
        help(val, mid + 1, end, ans);
        int leftPos = start;
        int rightPos = mid + 1;
        int leftNumberBiggerRight = 0;
        List<ValueIndex> merge = new ArrayList<>();
        while (leftPos < mid + 1 && rightPos <= end) {
            if (val[leftPos].val > val[rightPos].val) {
                leftNumberBiggerRight++;
                merge.add(val[rightPos]);
                rightPos++;
            } else {
                ans[val[leftPos].idx] += leftNumberBiggerRight;
                merge.add(val[leftPos]);
                leftPos++;
            }
        }
        while (leftPos < mid + 1) {
            ans[val[leftPos].idx] += leftNumberBiggerRight;
            merge.add(val[leftPos]);
            leftPos++;
        }

        while (rightPos <= end) {
            merge.add(val[rightPos]);
            rightPos++;
        }
        int pos = start;
        for (ValueIndex valueIndex : merge) {
            val[pos] = valueIndex;
            pos++;
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        CountofSmallerNumbersAfterSelf c = new CountofSmallerNumbersAfterSelf();
        List<Integer> a = c.countSmaller(nums);
        for (Integer integer : a) {
            System.out.println("integer = " + integer);
        }
    }
}
