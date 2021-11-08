package com.alg;

/**
 * Created by chengxu03 on 2021/9/9.
 */
public class LongestHappyPrefix {


    public String longestPrefix(String s) {

        int n = s.length();
        int[] lps = new int[n];
        lps[0] = 0;
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = lps[j - 1];
            if (s.charAt(i) == s.charAt(j)){
                lps[i] = ++j;
            }
        }
        return s.substring(0,lps[n-1]);
    }


    public static void main(String[] args) {
        String s  = "ababab";
        LongestHappyPrefix h = new LongestHappyPrefix();
        System.out.println("h = "+h.longestPrefix(s));
    }
}
