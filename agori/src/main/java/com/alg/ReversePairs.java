package com.alg;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/7/9
 */
public class ReversePairs {


    public int reversePairs(int[] nums) {
        int len = nums.length;
        return mergeSort(nums, 0, len - 1);

    }

    private int mergeSort(int[] nums, int lo, int hi) {


        if (lo >= hi){
            return  0;
        }

        int mid = lo + (hi - lo) / 2;
        int sum = 0;
        sum += mergeSort(nums, lo, mid);
        sum += mergeSort(nums, mid + 1, hi);
        sum += merge(nums, lo, mid , hi);
        return sum;


    }

    private int merge(int[] nums, int lo, int mid, int hi) {

        int p = lo, q = mid + 1;
        int count = 0;
        while (p <= mid && q <= hi) {
            if ((long) nums[p] > (long) (nums[q] * 2)) {
                count += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }




        int a[] = new int[hi - lo + 1];
        p = lo;
        q = mid + 1;
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
        return count;


    }


    public static void main(String[] args) {
        int [] a = new int[]{1,3,2,3,1};
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(" = " + reversePairs.reversePairs(a));

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[i] = " + a[i]);
        }
    }
}
