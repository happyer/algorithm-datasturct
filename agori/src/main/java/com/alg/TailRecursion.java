package com.alg;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/12
 */
public class TailRecursion {



    private static int helperTailRecursion(int start, int [] ls, int acc) {
        if (start >= ls.length) {
            return acc;
        }
        // this is a tail recursion because the final instruction is the recursive call.
        return helperTailRecursion(start+1, ls, acc+ls[start]);
    }

    public static int sumTailRecursion(int [] ls) {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helperTailRecursion(0, ls, 0);
    }

    private static int helper_non_tail_recursion(int start, int [] ls) {
        if (start >= ls.length) {
            return 0;
        }
        // not a tail recursion because it does some computation after the rturned.
        return ls[start] + helper_non_tail_recursion(start+1, ls);
    }

    public static int sum_non_tail_recursion(int [] ls) {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helper_non_tail_recursion(0, ls);
    }
}
