package com.alg;

/**
 * Created by chengxu03 on 2021/10/19.
 */
public class BasicCalculator {

    public int calculate(String s) {
        return helpCalculate(s, 0);
    }

    private int helpCalculate(String s, int index) {
        int sign = 1;
        int result = 0;
        int num = 0;
        if (s.length() == index) {
            return result;
        }
        while (index < s.length()) {

            Character ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch;
                continue;
            }
            if (ch == '+') {
                sign = 1;
                continue;
            }
            if (ch == '-'){
                sign = -1;
                continue;
            }
            if (ch == '('){
                result += num+ (sign*helpCalculate(s,index));
                num = 0;
                sign = 1;
                continue;
            }
            if (ch ==')'){
               return result;
            }
        }


        return result;
    }
}
