package com.alg;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by chauncy on 2018/4/19.
 */
public class MultiThreadSort {


    /**
     * 采用merge sort 的思想,使用Java 的forkjoin 框架来并行的进行排序
     *
     * @param array
     * @return
     */
    public int[] sort(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MultilMergeSort(array));
        return array;
    }


    private static class MultilMergeSort extends RecursiveAction {

        private static final long serialVersionUID = 425572392953885545L;
        private int[] intArr;

        public MultilMergeSort(int[] intArr) {
            this.intArr = intArr;
        }

        @Override
        protected void compute() {
            if (intArr.length > 1) {
                // 如果数组长度大于1就分解称两份
                int[] leftArray = Arrays.copyOfRange(intArr, 0, intArr.length / 2);
                int[] rightArray = Arrays.copyOfRange(intArr, intArr.length / 2, intArr.length);

                // 这里分成两份执行
                invokeAll(new MultilMergeSort(leftArray), new MultilMergeSort(rightArray));

                // 合并且排序
                merge(leftArray, rightArray, intArr);
            }
        }

        /**
         * 将两个硬拍好序的数组进行一个归并
         *
         * @param leftArray
         * @param rightArray
         * @param intArr
         */
        private void merge(int[] leftArray, int[] rightArray, int[] intArr) {

            // i：leftArray数组索引，j：rightArray数组索引，k：intArr数组索引
            int i = 0, j = 0, k = 0;
            while (i < leftArray.length && j < rightArray.length) {
                // 当两个数组中都有值的时候，比较当前元素进行选择
                if (leftArray[i] < rightArray[j]) {
                    intArr[k] = leftArray[i];
                    i++;
                } else {
                    intArr[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            // 将还剩余元素没有遍历完的数组直接追加到intArr后面
            if (i == leftArray.length) {
                for (; j < rightArray.length; j++, k++) {
                    intArr[k] = rightArray[j];
                }
            } else {
                for (; i < leftArray.length; i++, k++) {
                    intArr[k] = leftArray[i];
                }
            }
        }


    }


    public static int[] generatorArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int v = random.nextInt();
            array[i] = v;
        }
        return array;
    }

    public static void print(int[] array) {
        for (int i : array) {
            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) {
        MultiThreadSort mutilThreadSort = new MultiThreadSort();
        int[] array = generatorArray(10_000_000);
        mutilThreadSort.sort(array);
//        int a[] = {5, 4, 2, 6, 7, 8};
//        mutilThreadSort.sort(a);
//        print(array);
    }

}
