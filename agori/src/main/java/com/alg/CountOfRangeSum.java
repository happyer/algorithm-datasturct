package com.alg;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/7/10
 */
public class CountOfRangeSum {


    /**
     * 在固定 j 之后，可以等价于寻找符合i 的  sum(j) - upper  <= sum(i) <= sum(j)-lower   [j > i] 个数
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return mergeSort(sums, 0, n-1 , lower, upper);
    }

    private int mergeSort(int[] nums, int lo, int hi, int lower, int upper) {
        if (lo >= hi) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int sum = 0;
        sum += mergeSort(nums, lo, mid, lower, upper);
        sum += mergeSort(nums, mid + 1, hi, lower, upper);

        /**
         * 可以先固定 i(之后一个一个进行遍历，但是利用sort ,可以降低到查找复杂度)，即是 merge sort 的左边部分，然后去寻找 有多少个符合 范围的数，使用startIndex 记录大于lower 的开始，然后在使用
         * endIndex 记录结束的upper 最后个数就是end - start
         */
        int startIndex = mid+1, endIndex = mid+1;
        for (int i = lo; i <= mid; i++) {
            while (startIndex <= hi && nums[startIndex] - nums[i] < lower) {
                startIndex++;
            }

            while (endIndex <= hi && nums[endIndex] - nums[i] <= upper) {
                endIndex++;
            }

            sum += endIndex - startIndex;
        }
        merge(nums, lo, mid, hi);
        return sum;
    }

    /**
     * normal merge
     *
     * @param nums
     * @param lo
     * @param mid
     * @param hi
     */
    private void merge(int[] nums, int lo, int mid, int hi) {
        int a[] = new int[hi - lo + 1];
        int p = lo;
        int q = mid + 1;
        int i = 0;
        while (p <= mid && q <= hi) {
            if (nums[p] < nums[q]) {
                a[i++] = nums[p++];
            } else {
                a[i++] = nums[q++];
            }
        }

        while (p <= mid) {
            a[i++] = nums[p++];
        }

        while (q <= hi) {
            a[i++] = nums[q++];
        }

        System.arraycopy(a, 0, nums, lo, a.length);
    }


    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;
        CountOfRangeSum countOfRangeSum = new CountOfRangeSum();
        System.out.println(" = " + countOfRangeSum.countRangeSum(nums, lower, upper));
    }
}
