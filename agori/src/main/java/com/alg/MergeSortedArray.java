package com.alg;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] n1 = new int[] {1,0};
        int[] n2 = new int[] {1};

        merge(n1, 1, n2, 1);
        for (int i : n1) {
            System.out.println("i = " + i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m + n];

        if (n == 0)
            return;
        if (m == 0) {

            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int l = Math.min(m, n);
        int index = 0;
        int i = 0;
        int j = 0;
        for (int k = 0; k <= l; k++) {
            if (nums1[i] > nums2[j]) {
                res[index++] = nums2[j];
                j++;
            } else {
                res[index++] = nums1[i];
                i++;
            }
        }

        if (j > n) {
            while (i < m) {

                res[index++] = nums1[i++];
            }
        } else {
            while (j < n) {

                res[index++] = nums2[j++];
            }
        }

        for (int i1 = 0; i1 < res.length; i1++) {
            nums1[i1] = res[i1];
        }

    }
}
