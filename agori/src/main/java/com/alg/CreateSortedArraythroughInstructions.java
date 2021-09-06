package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengxu03 on 2021/8/27.
 */
public class CreateSortedArraythroughInstructions {


    public static class Bean {
        int lessCnt =0;
        int moreCnt = 0;
        int val;

        public Bean(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        int a[] = new int[]{1, 5, 6, 2};
        CreateSortedArraythroughInstructions c = new CreateSortedArraythroughInstructions();
        System.out.println(" = " +c.createSortedArray(a));
    }


    public int createSortedArray(int[] instructions) {


        Bean[] a = new Bean[instructions.length];
        for (int i = 0; i < instructions.length; i++) {
            a[i] = new Bean(instructions[i]);
        }
        partition(a, 0, a.length - 1);
        int cost = 0;
        for (Bean bean : a) {
            cost += Math.min(bean.lessCnt, bean.moreCnt);
        }
        return cost;
    }

    private void partition(Bean[] a, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        partition(a, l, mid);
        partition(a, mid + 1, r);
        merge(a, l, mid, mid + 1, r);
    }

    private void merge(Bean[] a, int start1, int end1, int start2, int end2) {

        List<Bean> merged = new ArrayList<>();

        int cur1 = start1;
        int cur2 = start2;
        while (cur1 <= end1 && cur2 <= end2) {
            if (a[cur1].val < a[cur2].val) {
                merged.add(a[cur1]);
                cur1++;
            } else {
                int less = cur1 - start1;
                while (cur1 <= end1 && a[cur1].val == a[cur2].val) {
                    merged.add(a[cur1]);
                    cur1++;
                }
                int bigger = end1 - cur1;
                int val = a[cur2].val;
                while (cur2 <= end2 && a[cur2].val == val) {
                    a[cur2].lessCnt += less;
                    a[cur2].moreCnt += bigger;
                    merged.add(a[cur2]);
                    cur2++;
                }
            }
        }

        while (cur1 <= end1) {
            merged.add(a[cur1]);
            cur1++;
        }

        while (cur2 <= end2) {
            a[cur2].lessCnt += end1 - start1 + 1;
            merged.add(a[cur2]);
            cur2++;
        }
        int j = 0;
        for (int i = start1; i <= end1; i++) {
            a[i] = merged.get(j);
            j++;
        }
    }
}
