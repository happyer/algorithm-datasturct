package com.alg;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2022/1/16
 */
public class ParseLispExpression {


    public static int pos = 0;

    public List<Integer> queue = new ArrayList<>();

    public int evaluate(String expression) {

        return evl(expression, 0);


    }

    private int evl(String expression, int i) {
        if (expression.charAt(i) == '(') {
            pos++;
        }
        String token = getToken(expression, pos);
        int val = 0;

        if (token.equals("add")) {
            //skip space
            pos++;
            int first = evl(expression, pos);
            int second = evl(expression, pos);
            val = first + second;
        } else if (token.equals("mul")) {
            int first = evl(expression, pos);
            int second = evl(expression, pos);
            val = first * second;
        } else if (token.equals("let")) {


        }else  if (Character.isAlphabetic(token.charAt(0))){
            //var able
        }
        else {
            // present is space，skip space
            pos++;
            token = getToken(expression, pos);
            return (Integer.parseInt(token));
        }

        return 0;
    }



    private String getToken(String expression, int pos) {
        StringBuilder sb = new StringBuilder();
        while (expression.charAt(pos) != ' ' || expression.charAt(pos) != ')') {
            sb.append(expression.charAt(pos));
            pos++;
        }
        return sb.toString();
    }

}
