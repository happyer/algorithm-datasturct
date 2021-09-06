package com.alg;

/**
 * Created by chengxu03 on 2021/8/20.
 */
public class RollingHash {


    private Long base = 1000000l;

    private Long[] hashes;

    private long[] pPower;

    private String s;

    public RollingHash(String s) {
        this.s = s;
        hashes = new Long[s.length()];
    }

    public void compute() {
        long hash = 0;

        pPower[0] = 1;

        for (int i = 1; i < s.toCharArray().length; i++) {
            hash = hash * base + Integer.valueOf(s.charAt(i - 1));
            hashes[i] = hash;
            pPower[i] = pPower[i - 1] * base;
        }
    }

    public long get(Integer i, Integer j) {
        if (i > j) throw new IllegalArgumentException("param error");
        return hashes[j] - hashes[i] * pPower[j - i];
    }


}
