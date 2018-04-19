package com.alg;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        System.out.println(" = " +isValid("([)]"));
    }

    public  static boolean isValid(String s) {


        //'(', ')', '{', '}', '[' and ']'
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c ==')' && stack.peek()=='('){
                stack.pop();
                continue;
            }
            if (c=='}' && stack.peek()=='{'){
                stack.pop();
                continue;
            }
            if (c==']' && stack.peek()=='['){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.size() ==0;

    }
}
