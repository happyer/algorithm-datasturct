package com.alg;

/**
 * Created by chauncy on 2018/5/15.
 */
public class EvaluateReversePolishNotation {


    /**
     * 递归版本  ,stack 也可以
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        return evalRPN(tokens, tokens.length - 1);
    }

    public static int evalRPN(String[] tokens, int i) {
        if (i < 0) return 0;
        int x, y;
        final String token = tokens[i--];
        if (isOperator(token)) {
            x = evalRPN(tokens, i--);
            y = evalRPN(tokens, i--);
            switch (token.charAt(0)) {
                case '+':
                    x += y;
                    break;
                case '-':
                    x -= y;
                    break;
                case '*':
                    x *= y;
                    break;
                case '/':
                    x /= y;
                    break;
            }
        }else {
            x = Integer.parseInt(token);
        }
        return x;

    }

    public static String OPS = "+/*-";

    public static boolean isOperator(String token) {
        return token.length() == 1 && OPS.indexOf(token) != -1;
    }
}
