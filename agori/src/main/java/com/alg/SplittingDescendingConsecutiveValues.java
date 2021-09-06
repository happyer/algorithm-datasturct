package com.alg;

/**
 * Created by chengxu03 on 2021/8/2.
 */
public class SplittingDescendingConsecutiveValues {


    public static void main(String[] args) {
        SplittingDescendingConsecutiveValues splittingDescendingConsecutiveValues = new SplittingDescendingConsecutiveValues();
//        String s = "050043";
        String s = "1234";
        boolean ans = splittingDescendingConsecutiveValues.splitString(s);
        System.out.println("ans = " + ans);
    }


    boolean found = false;

    public boolean splitString(String s) {
        backtrack(s, 0, 0, -1);
        return found;
    }

    public void backtrack(String s, int i, int count, long previousNum) {
        if (i >= s.length()) {
            if (count > 1) found = true;
            return;
        }

        long number = 0;

        for (; i < s.length(); i++) {
            number = number * 10 + s.charAt(i) - '0';

            if (previousNum == -1 && number > 0) {
                backtrack(s, i + 1, count + 1, number);
                if (found) return;
            }

            if (previousNum != -1 && previousNum >= number && previousNum - number == 1) {
                backtrack(s, i + 1, count + 1, number);
                if (found) return;
            }

        }
    }


}
