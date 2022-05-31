package com.alg;

import java.nio.MappedByteBuffer;
import java.util.*;

/**
 * Created by chengxu03 on 2021/7/30.
 */
public class VerbalArithmeticPuzzle {

    public static void main(String[] args) {
        //words = ["THIS","IS","TOO"], result = "FUNNY"
        String[] worlds = new String[]{"LEET","CODE"};
        String result = "POINT";
        boolean ans = isSolvable(worlds,result);
        System.out.println("ans = " + ans);


    }


    private static boolean isAns;

    public static boolean isSolvable(String[] words, String result) {


        Set<Character> ws = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                ws.add(c);
            }
        }
        for (char c : result.toCharArray()) {
            ws.add(c);
        }


        Map<Character, Integer> mapping = new HashMap<>();

        List<Character> wss = new ArrayList<>(ws);
        Set<Integer> usedNumber = new HashSet<>();

        dfs(words, result, wss, mapping, 0,usedNumber);

        return isAns;

    }


    private static void dfs(String[] words, String result, List<Character> ws, Map<Character, Integer> mapping, int n,Set<Integer> usedNumber) {

        if (n == ws.size()) {
            //模拟mapping  结束 可以进行计算
            if (isStatistic(words, result, mapping)) {
                isAns = true;
                return;
            }
            return;
        }

        Character key = ws.get(n);

        for (int i = 0; i <= 9; i++) {


            //todo pruning,可以进行一些与计算 比如 左边的数值开始是9 并且长度跟候右边的长度一样，
            // 且右边的不是9 开头的，那么这个结果肯定不对,left start  > right start && left.lenth >= right.length

            if (!usedNumber.contains(i)){
                mapping.put(key, i);
                usedNumber.add(i);
                dfs(words, result, ws, mapping, n + 1,usedNumber);
                mapping.remove(key);
                usedNumber.remove(i);
            }

        }
    }


    private static boolean isStatistic(String[] words, String result, Map<Character, Integer> mapping) {


        Long leftTotal = 0l;
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(mapping.get(c));
            }
            leftTotal += Long.parseLong(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (char c : result.toCharArray()) {
            sb2.append(mapping.get(c));
        }
        Long right = Long.parseLong(sb2.toString());
        if (leftTotal.equals(right)) {
            return true;
        } else {
            return false;
        }
    }

}
