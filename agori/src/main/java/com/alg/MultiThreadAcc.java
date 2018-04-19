package com.alg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by chauncy on 2018/4/20.
 */
public class MultiThreadAcc {


    public static void main(String[] args) throws InterruptedException {

        Latch latch = new Latch(10);


        List<Integer> integers = new ArrayList<>(100_000);
        for (int i = 1; i < 100_000; i++) {
            integers.add(i);
        }


        int[] res = new int[10];
        Collection<List<Integer>> lists = partition(integers, 10000);
        List<List<Integer>> s = lists.parallelStream().collect(Collectors.toList());
        for (int i = 0; i < s.size(); i++) {
            new Thread(new Acc(s.get(i), latch, i, res)).start();
        }
        latch.await();
        int r = IntStream.of(res).sum();
        System.out.println("r = " + r);


    }


    private static Collection<List<Integer>> partition(List<Integer> list, int size) {
        final AtomicInteger counter = new AtomicInteger(0);
        return list.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                .values();
    }

    public static class Latch {
        private final Object object = new Object();
        private int count;


        public Latch(int count) {
            this.count = count;
        }

        public void await() throws InterruptedException {
            synchronized (object) {
                while (count > 0) {
                    object.wait();
                }
            }
        }


        public void countDown() {
            synchronized (object) {
                if (--count <= 0) {
                    object.notify();
                }
            }
        }

    }


    public static class Acc implements Runnable {

        private List<Integer> a;
        private Latch latch;

        private int i;
        private int[] res;

        /**
         * @param a     data
         * @param latch
         * @param i     result index
         * @param res   result array
         */
        public Acc(List<Integer> a, Latch latch, int i, int[] res) {
            this.a = a;
            this.latch = latch;
            this.i = i;
            this.res = res;
        }

        @Override
        public void run() {
            int r = a.parallelStream().reduce((integer, integer2) -> integer2 + integer).get();
            res[i] = r;
            System.out.println(String.format("this %d thread complate!", i));
            latch.countDown();

        }
    }


}
