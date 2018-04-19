package com.alg;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] += 1;
        while (digits[i] == 0 && i >= 0) {
            digits[i] = 0;
            digits[i - 1] += 1;
            i--;
        }
        if (digits[i] == 10) {
            //explan
            int[] res = new int[digits.length + 1];
            for (int k = 1; k < digits.length + 1; k++) {
                res[k] = 0;
            }
            res[0] = 1;
            return res;
        }
        return digits;

    }
}
