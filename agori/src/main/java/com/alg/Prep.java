package com.alg;

import java.util.*;

/**
 * Created by chengxu03 on 2022/5/31.
 */
public class Prep {

    public static List<List<String>> ret = new ArrayList<List<String>>();

    public static void main(String[] args) {


        List arr = new ArrayList();
        arr.add("a");
        arr.add("b");
        arr.add("c");

        help(arr, arr.size(), new ArrayList<String>(), 1, new HashSet<String>());

        System.out.println("ret = " + ret);


    }

    private static void help(List<String> src, int length, ArrayList<String> integers, int idx, Set<String> visit ) {

        if (src == null || src.size() == 0) {
            return;
        }
        for (int i = 0; i < src.size(); i++) {
            String tmp = src.get(i);
            if (visit.contains(tmp)){
                continue;
            }
            integers.add(tmp);
            if (idx >= length) {
                ret.add(new ArrayList<String>(integers));
            }
            visit.add(tmp);
            help(src, length, integers, idx + 1,visit);
            integers.remove(integers.size()-1);
            visit.remove(tmp);
        }
    }

}
