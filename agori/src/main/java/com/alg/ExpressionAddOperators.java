package com.alg;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public static void main(String[] args) {
        String a="123";
        for (String s : addOperators(a, 6)) {
            System.out.println("s = " + s);
        }

    }


    /**
     * When we use dfs to do this question, the most tricky part is that how to deal with multiplication. For every
     * addition and subtraction, we just directly adding or subtracting the new number. However, for multiplication,
     * we should multiply current number and previous number firstly, and then add previous previous number.
     * So we can use a variable preNum to record every previous number in each recursion step. If current recursive
     * call is trying multiplication, we should use previous calculation value subtract previous number, and then
     * adding multiplication result between previous number and current number.
     * */
    public static List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(num, "", result, 0, 0, 0, target);
        return result;
    }

    public static void dfs(String src, String express, List<String> ans, long prev, long current, int position,
        int target) {
        if (position == src.length()) {
            if (current == target) {
                ans.add(express);
            }
            return;

        }
        // start from first index of current position in num string, try all possible length of nums
        for (int i = position; i < src.length(); i++) {
            // corner case: if current position is 0, we can only use it as a single digit number, should be 0
            // if it is not a single digit number with leading 0, it should be considered as an invalid number
            if (position != i && src.charAt(position) == '0') {
                break;
            }
            long val = Long.parseLong(src.substring(position, i + 1));
            // position 0 should be considered individually, since it does not have any operand character before
            if (position == 0) {
                dfs(src, express + val, ans, val, val, i + 1, target);
            } else {
                dfs(src, express + "+" + val, ans, val, current + val, position + 1, target);
                dfs(src, express + "-" + val, ans, -val, current - val, position + 1, target);
                dfs(src, express + "*" + val, ans, prev * val, current - prev + prev * val, position + 1, target);
            }
        }

    }

}
