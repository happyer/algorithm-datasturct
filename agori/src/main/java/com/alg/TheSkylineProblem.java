package com.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2021/11/14
 */
public class TheSkylineProblem {


    public static class Event implements Comparable<Event> {

        public String type;
        public int x;
        public int h;


        @Override
        public int compareTo(Event o) {
            return this.x != o.x ? (this.x - o.x) : (this.h - o.h);
        }
    }


    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<Event> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] building : buildings) {
            String type = "entry";
            int x = building[0];
            int h = building[2];
            Event event = new Event();
            event.x = x;
            event.type = type;
            event.h = h;
            list.add(event);
            type = "leave";
            x = building[1];
            Event event1 = new Event();
            event1.type = type;
            event1.x = x;
            event1.h = h;
            list.add(event1);

        }

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        for (Event event : list) {
            String type = event.type;
            if (type.equals("entry")) {
                if (event.h > pq.peek()) {
                    ans.add(Arrays.asList(event.x, event.h));
                }
                pq.add(event.h);
            } else {
                pq.remove(pq.peek());
                if (event.h > pq.peek()) {
                    ans.add(Arrays.asList(event.x, event.h));
                }
            }
        }
        return ans;


    }

}
