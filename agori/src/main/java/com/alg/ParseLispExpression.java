package com.alg;

import java.util.*;

/**
 * Created by chengxu03 on 2022/1/16.
 */
public class ParseLispExpression {


    public static int pos = 0;

    public static void main(String[] args) {
//        String t = "( add 2 ( add 2 3 ) ) ";
        String t = "( let x 1 y 2 ( add x y) ) ";
        ParseLispExpression expression = new ParseLispExpression();
        int ans = expression.evaluate(t);
        System.out.println("ans = " + ans);
    }


    public int evaluate(String expression) {


        //skip （ of start，）of end

//        return help(expression, new HashMap<String, Integer>());

        return eval(expression, new HashMap<>());
    }

    private int eval(String expression, HashMap<String, Deque<Integer>> map) {
        char ch = expression.charAt(1);  // the expression must start with "(add " or "(mult " or "(let ".
        if (ch == 'a') {
            return evalAdd(expression, map);
        } else if (ch == 'm') {
            return evalMul(expression, map);
        } else if (ch == 'l') {
            return evalLet(expression, map);
        }
        return 0;

    }

    private int evalLet(String expression, HashMap<String, Deque<Integer>> map) {
        //(let x y (add 1 2))
        List<String> variables = new ArrayList<>();
        int res = 0;
        int offset = 5;
        while (offset < expression.length()) {
            String op = getOperand(expression, offset);
            offset += op.length() + 1;
            String op2 = getOperand(expression, offset);
            if (op2 == null) {
                res = evalOp(op, map);
                break;
            }
            offset += op2.length()+1;
            variables.add(op);

            if (!map.containsKey(op)){
                map.put(op,new ArrayDeque<>());
            }
            map.get(op).addFirst(eval(expression,map));
        }
        for (int i = variables.size() - 1; i >= 0; i--) {
            String var = variables.get(i);
            Deque<Integer> integers =  map.get(var);
            integers.pollFirst();
            if (integers.isEmpty()){
                map.remove(var);
            }
        }


        return res;
    }

    private int evalMul(String expression, HashMap<String, Deque<Integer>> map) {
        int offset = 5; // "(add "  length 5
        String o1 = getOperand(expression, offset);
        offset += o1.length() + 1;
        String o2 = getOperand(expression, offset);

        return evalOp(o1, map) * evalOp(o2, map);
    }

    private int evalAdd(String expression, HashMap<String, Deque<Integer>> map) {
        int offset = 5; // "(add "  length 5
        String o1 = getOperand(expression, offset);
        offset += o1.length() + 1;
        String o2 = getOperand(expression, offset);

        return evalOp(o1, map) + evalOp(o2, map);
    }


    private int evalOp(String o1, HashMap<String, Deque<Integer>> map) {
        char ch = o1.charAt(0);
        if (ch == '-' || Character.isDigit(ch)) {
            return Integer.parseInt(o1);
        } else if (Character.isAlphabetic(ch)) {
            return map.get(o1).pollFirst();
        } else {
            return eval(o1, map);
        }
    }


    private String getOperand(String e, int offset) {
        if (offset >= e.length()) return null;  // invalid offset

        char c = e.charAt(offset);
        int start = offset;

        if (c == '-' || Character.isDigit(c)) {  // operand is an integer
            if (c == '-') offset++;
            while (offset < e.length() && Character.isDigit(e.charAt(offset))) offset++;

        } else if (Character.isLowerCase(c)) {  // operand is a variable
            while (offset < e.length() && Character.isLetterOrDigit(e.charAt(offset))) offset++;

        } else {                                // operand is another expression enclosed in parentheses
            for (int cnt = 0; offset < e.length(); ) {
                c = e.charAt(offset++);
                if (c == '(') cnt++;
                if (c == ')') cnt--;
                if (cnt == 0) break;
            }
        }

        return e.substring(start, offset);
    }

    private int help(String s, Map<String, Integer> map) {


        if (s.charAt(0) == '-' || (s.charAt(0) >= '1'
                && s.charAt(0) <= '9')) {
            return Integer.parseInt(s);
        } else if (s.charAt(0) != '(') {
            //variable
            return map.get(s);
        }
        //skip ( of start ,and ) of end
        String str = s.substring(1, s.length() - 2);
        String token = parse(str, pos);
        if (token.equals("let")) {
            while (true) {
                String variable = parse(str, pos);
                if (pos >= str.length()) {
                    return help(variable, map);
                }
                String temp = parse(str, pos);
                map.put(variable, help(temp, map));
            }
        } else if (token.equals("add")) {
            return help(parse(str, pos), map) + help(parse(str, pos), map);
        } else if (token.equals("mul")) {
            return help(parse(str, pos), map) * help(parse(str, pos), map);
        }
        return 0;
    }

    private String parse(String str, int pos) {
        return null;
    }

    private List<Map<String, Integer>> q = new ArrayList<>();

    private int help(String expression) {
        if (expression.charAt(pos) == '(') {
            pos++;
        }
        if (expression.charAt(pos) == 32) {
            ++pos;
        }
        if (expression.charAt(pos) == ')') {
            ++pos;
        }
        String toke = getToken(expression);
        if (toke.equals("add")) {
            int val1 = help(expression);
            int val2 = help(expression);
            return val1 + val2;

        }
        if (toke.equals("mul")) {
            int val = help(expression);
            int val2 = help(expression);
            return val * val2;

        }
        if (toke.equals("let")) {
            //（ let x 1 y 2 x add (x y ) add ( x y ) ）
            ++pos; //skip space
            return help(expression);
        }
        if (Character.isAlphabetic(toke.charAt(0))) {
            //variable
            String valName = toke;
//            for (int i = q.size() - 1; i >= 0; i--) {
//                if (q.get(i).containsKey(valName)) {
//                    return q.get(i).get(valName);
//                }
//            }
            int val = help(expression);
            Map<String, Integer> map = new HashMap<>();
            map.put(valName, val);
            q.add(map);
            if (pos < expression.length()) {
                pos++;
                return help(expression);
            }
        }
        if (toke.charAt(0) == '-' || Character.isDigit(toke.charAt(0))) {
            return Integer.parseInt(toke);
        }
        if (toke.equals("(") && pos < expression.length()) {
            pos++;
            return help(expression);
        }
        return 0;

    }

    private String getToken(String expression) {
        StringBuilder sb = new StringBuilder();
        while (expression.charAt(pos) != 32 && expression.charAt(pos) != ')') {
            sb.append(expression.charAt(pos));
            pos++;
        }
        return sb.toString();
    }


}
