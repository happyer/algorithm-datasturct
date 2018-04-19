package com.alg;

import static java.lang.System.out;

/**
 * Created by chauncy on 2018/4/19.
 */
public class Retracement {


    /**
     * 计算回撤,这里的数组类型的单位可以根据实际情况而定,但是还是建议使用分为单位,这样口可以减少计算的误差
     * @param x
     */
    public static void retracementMaxDay(int[] x) {


        if (x == null) {
            throw new NullPointerException("not null");
        }
        if (x.length == 1) return;


        double maxValue = x[0];


        double maxDd = 0;
        double dd = 0;

        for (int j = 1; j < x.length; j++) {
            maxValue = Math.max(x[j], maxValue);
            dd = 1 - (x[j] / maxValue);
            maxDd = Math.max(dd, maxDd);
            out.printf("the %d th day maxV= %.2f\n", j, maxDd);
        }
        //if need max of all array
        //return maxDd;
    }


    public static void main(String[] args) {

        int a[] = {5, 4, 2, 6, 7, 8};

        retracementMaxDay(a);

    }


}
