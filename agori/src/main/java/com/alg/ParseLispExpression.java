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


    public int evaluate(String expression) {




        return help(expression, pos);


    }


    private List<Map<String,Integer>> q = new ArrayList<>();


    private int help(String expression, int p) {
        if (expression.charAt(p) == '('){
            p++;
        }
        if (expression.charAt(p) ==' ' ){
            ++p;
        }
        String toke = getToken(expression,p);
        if (toke =="add"){
            int val1 = help(expression,++p);
            int val2  = help(expression,++p);
            return val1+val2;

        }if (toke =="mul"){
            int val = help(expression,++p);
            int val2 = help(expression,++p);
            return val*val2;

        }if (toke =="let"){
            ++p; //skip space
            help(expression,p);
        }
        if (Character.isAlphabetic(toke.charAt(0))){
           //variable
           String valName = toke;
           int val = help(expression,p);
           Map<String,Integer> map = new HashMap<>();
           map.put(valName,val);
           q.add(map);
        }if (toke.charAt(0) =='-' || Character.isDigit(toke.charAt(0))){
            return Integer.parseInt(toke);
        }
        return 0;


    }

    private String getToken(String expression, int p) {
        return null;
    }


}
