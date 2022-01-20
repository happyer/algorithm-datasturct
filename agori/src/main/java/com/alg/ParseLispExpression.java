package com.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chengxu03 on 2022/1/16.
 */
public class ParseLispExpression {


    public static int pos = 0;

    public static void main(String[] args) {
        String t = "( add 2 3 ) ";
        ParseLispExpression expression = new ParseLispExpression();
        int ans  = expression.evaluate(t);
        System.out.println("ans = " + ans);
    }



    public int evaluate(String expression) {




        return help(expression);


    }


    private List<Map<String,Integer>> q = new ArrayList<>();


    private int help(String expression) {
        if (expression.charAt(pos) == '('){
            pos++;
        }
        if (expression.charAt(pos) == 32 ){
            ++pos;
        }
        String toke = getToken(expression);
        if (toke.equals("add")){
            int val1 = help(expression);
            int val2  = help(expression);
            return val1+val2;

        }if (toke.equals("mul")){
            int val = help(expression);
            int val2 = help(expression);
            return val*val2;

        }if (toke.equals("let")){
            ++pos; //skip space
            return help(expression);
        }
        if (Character.isAlphabetic(toke.charAt(0))){
           //variable
           String valName = toke;
           int val = help(expression);
           Map<String,Integer> map = new HashMap<>();
           map.put(valName,val);
           q.add(map);
        }if (toke.charAt(0) =='-' || Character.isDigit(toke.charAt(0))){
            return Integer.parseInt(toke);
        }
        return 0;


    }

    private String getToken(String expression) {
        StringBuilder sb = new StringBuilder();
        while (expression.charAt(pos) != 32 && expression.charAt(pos) != ')'){
            sb.append(expression.charAt(pos));
            pos++;
        }
        return sb.toString();
    }


}
