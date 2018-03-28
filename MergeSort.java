package com.souche;

/**
 * Created by chauncy on 2018/3/28.
 */
public class MergeSort {


    public static void main(String[] args) {
        int a[] = {5, 4, 2, 6, 7, 8};
        mergeSort(a);
        printArrray(a);
    }


    public static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        mergeSortRecursive(arr, result, 0, len - 1);
    }

    public static void printArrray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[i] = " + a[i]);
        }
    }


}
