package com.alg;


import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chengxu03 on 2021/9/22.
 */
public class DecodeString {


    //Input: s = "2[abc]3[cd]ef"
    //Output: "abcabccdcdcdef"


    //Input: s = "3[a2[cd]]"
    //Output: "accaccdaccd"


    public static void main(String[] args) {
//        String s = "2[abc]3[cd]ef";
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        DecodeString decodeString = new DecodeString();
        String as = decodeString.decodeString(s);
        System.out.println(as);


        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        String ans  = decodeString.decodeStringRecursion(queue);
        System.out.println(ans);



    }

    public String decodeStringRecursion(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                String str = decodeStringRecursion(queue);
                for (int i = 0; i < num; i++) {
                    sb.append(str);
                }
                num  =0;
            }else if (ch == ']'){
                break;
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();

    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (stack.peek() == (']')) {
                StringBuilder sb = new StringBuilder();
                StringBuilder numSb = new StringBuilder();
                stack.pop();
                while (!stack.isEmpty()) {
                    Character temp = stack.pop();
                    if (Character.isAlphabetic(temp)) {
                        sb.append(temp);
                    } else if (Character.isDigit(temp)) {
                        numSb.append(temp);
                    }
                    if (numSb.length() > 0 && (stack.isEmpty() || stack.peek() == '[' || Character.isAlphabetic(stack.peek()))) {
                        break;
                    }
                }
                int num = numSb.length() > 0 ? Integer.valueOf(numSb.reverse().toString()) : 1;
                String rep = sb.reverse().toString();
                for (int i = 0; i < num; i++) {
                    for (char c1 : rep.toCharArray()) {
                        stack.push(c1);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }


}
