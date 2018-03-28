package com.souche;

/**
 * Created by chauncy on 2018/3/28.
 */
public class QuickSort {


    public static void main(String[] args) {
        int a[] = {5, 4, 2, 6, 7, 8};
        qsort(a, 0, a.length);
        printArrray(a);
    }


    public static void qsort(int a[], int l, int u) {
        int pivot, i, j;
        if (l < u - 1) {
            pivot = i = l;
            j = u;
            while (true) {
                while (i < u && a[++i] < a[pivot]) ;
                while (j >= l && a[pivot] < a[--j]) ;
                if (j < i) break;
                exchange(a, i, j);
            }
            exchange(a, pivot, j);
            qsort(a, l, j);
            qsort(a, i, u);
        }
    }


    public static void exchange(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public static void printArrray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[i] = " + a[i]);
        }
    }




}
