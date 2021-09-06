package com.alg;

/**
 * Created by chengxu03 on 2021/8/31.
 */
public class KMP {


    public static void main(String[] args) {
        String str = "ABCABD";
        int[] next = new int[str.length()];
        next[0] = 0;
        getNext(str, next);
        for (int i : next) {
            System.out.println("i = " + i);
        }
    }

    private static void getNext(String str, int[] next) {
        int index = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(index)) {
                index++;
                next[i] = index;
            } else {
                while (index > 0 && str.charAt(i)!= str.charAt(index)){
                    index = next[index];
                }
                if (str.charAt(i) == str.charAt(index)){
                    index++;
                    next[i] = index;
                }else {
                    next[i] = index;
                }
            }

        }


    }


}
