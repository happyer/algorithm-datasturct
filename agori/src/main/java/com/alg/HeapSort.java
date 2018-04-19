package com.alg;

/**
 * Created by chauncy on 2018/3/28.
 */
public class HeapSort {


    public static void main(String[] args) {
        int a[] = {5, 4, 2, 6, 7, 8};
        //buildHeap(a, a.length);

        heapSort(a);
        printArrray(a);

    }


    public static void buildHeap(int a[], int size) {
        for (int i = size / 2; i >= 0; i--) {
            heapify(a, i, size);
        }
    }


    public static void heapify(int a[], int i, int size) {


        int left = getLeft(i);
        int right = getRight(i);

        int largest = i;

        if (left < size && a[i] < a[left]) {
            largest = left;
        }
        if (right < size && a[largest] < a[right]) {
            largest = right;
        }
        if (largest != i) {
            exchange(a, i, largest);
            heapify(a, largest, size);
        }
    }


    public static int getLeft(int i) {
        return 2 * i + 1;
    }

    public static int getRight(int i) {
        return 2 * i + 2;
    }

    public static void exchange(int a[], int src, int dest) {
        int tmp = a[src];
        a[src] = a[dest];
        a[dest] = tmp;
    }

    public static void printArrray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[i] = " + a[i]);
        }
    }

    public static void heapSort(int a[]) {
        //build heap
        buildHeap(a, a.length);
        for (int i = a.length - 1; i >= 0; i--) {
            exchange(a, 0, i);
            heapify(a, 0, i);
        }

    }


}
