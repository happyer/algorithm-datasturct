package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chauncy on 2018/5/14.
 */
public class InsertInterval {


    public static void main(String[] args) {


        List<Interval> list = new ArrayList<>();


        list.add(new Interval(1, 3));
        list.add(new Interval(6, 9));

        Interval interval = new Interval(2, 5);
        List<Interval> res = insert(list, interval);

        for (Interval re : res) {
            System.out.println("re = " + re.toString());
        }


    }


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return start + "-" + end;
        }
    }


    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result  = new ArrayList<>();
        for (Interval interval : intervals) {
            insert(result,interval);
        }
        return result;
    }


    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        for (int i = 0; i < intervals.size(); ) {
            Interval current = intervals.get(i);
            if (newInterval.end < current.start) {
                intervals.add(i, newInterval);
                return intervals;
            } else if (newInterval.start > current.end) {
                i++;
                continue;
            } else {
                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(newInterval.end, current.end);
                intervals.remove(i);
            }
        }
        intervals.add(newInterval);
        return intervals;

    }

}
