package com.alg;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book1 {

    public static void main(String[] args) {

//        multiple(2, 4, 6, 15).forEach(integer -> System.out.println("integer = " + integer));

        List<Integer> a = new ArrayList<>();
        a.add(1234);
        a.add(532632);
        List<List<Integer>> first = new ArrayList<>();
        first.add(a);

        List<Integer> a1 = new ArrayList<>();
        a1.add(234);
        a1.add(632633);
        first.add(a1);

        List<Integer> a2 = new ArrayList<>();
        a2.add(2354);
        a2.add(732634);
        first.add(a2);

        List<List<Integer>> sec = new ArrayList<>();

        List<Integer> s1 = new ArrayList<>();
        s1.add(1234);
        s1.add(532632);
        sec.add(s1);

        List<Integer> s2 = new ArrayList<>();
        s2.add(458);
        s2.add(642633);
        sec.add(s2);

        missingReservations(first, sec).forEach(integer -> System.out.println("integer = " + integer));

    }

    public static List<Integer> multiple(int x, int y, int z, int n) {

        List<Integer> res = new ArrayList<>();

        if (x != 0) {

            for (int i = 1; i <= n / x; i++) {
                if (x * i != z) {
                    res.add(x * i);
                }

            }
        }
        if (y != 0) {

            for (int j = 1; j <= n / y; j++) {
                if (y * j != z) {
                    res.add(y * j);
                }
            }
        }
        res.sort((o1, o2) -> o1 - o2);
        return res.stream().distinct().filter(integer -> integer % z != 0).collect(Collectors.toList());

    }

    static class Tuple2 {
        Integer id;
        Integer timeStmp;

        public Tuple2(Integer id, Integer timeStmp) {
            this.id = id;
            this.timeStmp = timeStmp;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getTimeStmp() {
            return timeStmp;
        }

        public void setTimeStmp(Integer timeStmp) {
            this.timeStmp = timeStmp;
        }

    }

    public static List<Integer> missingReservations(List<List<Integer>> firstReservationList,
        List<List<Integer>> secondReservationList) {
        // Write your code here

        List<Tuple2> f = new ArrayList<>();
        firstReservationList.forEach(integers -> {
            f.add(new Tuple2(integers.get(0), integers.get(1)));
        });

        List<Tuple2> s = new ArrayList<>();
        secondReservationList.forEach(integers -> {
            s.add(new Tuple2(integers.get(0), integers.get(1)));
        });

        List<Tuple2> r = new ArrayList<>();

        r.addAll(f);
        r.addAll(s);

        return r.parallelStream()
            .collect(Collectors.groupingBy(Tuple2::getId))
            .values().parallelStream().filter(tuple2s -> tuple2s.size() == 1)
            .map(tuple2s -> tuple2s.get(0))
            .sorted((o1, o2) -> o1.getTimeStmp() - o2.getTimeStmp())
            .map(tuple2 -> tuple2.getId())
            .collect(Collectors.toList());

    }

}
