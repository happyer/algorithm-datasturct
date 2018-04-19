package com.alg;

/**
 * Created by chauncy on 2018/5/14.
 */
public class ReverseInteger {


    public static int reverse(int x) {


        int t = x > 0 ? x : -x;
        long r = 0;
        for (; t > 0; t /= 10) {
            r = r * 10 + t % 10;
        }
        boolean sign = x > 0 ? false : true;
        if (r > 2147483647 || sign && r > Integer.MAX_VALUE) {
            return 0;
        } else {
            if (sign){
                return (int) -r;
            }else {
                return (int) r;
            }
        }

    }
}
