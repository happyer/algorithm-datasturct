package com.alg;

/**
 * Created by chengxu03 on 2021/7/28.
 */
public class IsAdditiveNumber {


    public static void main(String[] args) {
        System.out.println("args = " + isAdditiveNumber("123"));
    }


    public static boolean isAdditiveNumber(String src) {


        for (int i = 0; i < src.length() / 2; i++) {
            for (int j = i + 1; j - i <= src.length() / 2; j++) {
                if (help(src, 0, i, i + 1, j)) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean help(String src, int startIdx1, int endIdx1, int startIdx2, int endIdx2) {

        if ((src.charAt(startIdx1) == '0' && ((endIdx1 - startIdx1) > 0))
                || (src.charAt(startIdx2) == '0' && ((endIdx2 - startIdx2) > 0))
        ) {
            return false;
        }
        long first = Long.parseLong(src.substring(startIdx1, endIdx1 + 1));
        long second = Long.parseLong(src.substring(startIdx2, endIdx2 + 1));
        String sum = String.valueOf(first + second);
        int sumEndIdx = endIdx2 + sum.length();
        if (sumEndIdx < src.length() && src.substring(endIdx2 + 1, sumEndIdx + 1).equals(sum)) {

            if (sumEndIdx == src.length() - 1) {
                return true;
            }
            return help(src, startIdx2, endIdx2, endIdx2 + 1, sumEndIdx);
        }
        return false;

    }
}
