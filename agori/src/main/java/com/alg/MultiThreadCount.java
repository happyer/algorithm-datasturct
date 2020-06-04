package com.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : chengxu@corp.netease.com
 * @since : 2020/6/3
 */
public class MultiThreadCount {


    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = getList(100);
        List<List<Integer>> partitions = partition(list, 5);
        System.out.println("partitions = " + partitions.size());

        int[] rs =new int[partitions.size()];

        CountDownLatch count = new CountDownLatch(partitions.size());

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < partitions.size(); i++) {
            int finalI = i;
            executorService.submit(() -> {
                List<Integer> in = partitions.get(finalI);
                Integer r = in.stream().reduce((integer, integer2) -> integer2 += integer).get();
                rs[finalI] = r;
                count.countDown();
            });
        }

        count.await();
        int rr=0 ;
        for (int r : rs) {
            rr+=r;
        }
        System.out.println("rr = " + rr);

        System.out.println(" = " + list.stream().reduce((integer, integer2) -> integer2+=integer).get());
        executorService.shutdown();

    }


    public static List<List<Integer>> partition(List<Integer> list, int size) {
        List<List<Integer>> res = new ArrayList<>();
        int numPerPartition = list.size() / size;
        for (int i = 0; i < size; i++) {
            res.add(list.subList(i * numPerPartition, i * numPerPartition + numPerPartition));
        }
        return res;
    }


    public static List<Integer> getList(int n) {
        List<Integer> res = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            res.add(i);
        }
        return res;
    }
}
