package com.alg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chengxu03 on 2021/9/2.
 */
public class FindAllGoodStrings {


    public static void main(String[] args) {
        //2
        //"aa"
        //"da"
        //"b"



        //8
        //"leetcode"
        //"leetgoes"
        //"leet"

        FindAllGoodStrings f = new FindAllGoodStrings();
        long a = f.findGoodStrings(8, "leetcode", "leetgoes", "leet");
        System.out.println("f = " + a);


    }


    public int findGoodStrings(int n, String s1, String s2, String evil) {
        es = evil.toCharArray();
        //cal next array
        int index = 0;
        next = new int[es.length];
        next[0] = -1;
//        for (int i = 1; i < es.length; i++) {
//            if (es[i] == es[index]) {
//                next[i] = next[i - 1] + 1;
//                index++;
//            } else {
//                index = next[i - 1];
//                while (index >= 0 && es[i] != es[index]) {
//                    index = next[index - 1];
//                }
//                if (es[i] == es[index]) {
//                    index++;
//                }
//                next[i] = index;
//            }
//        }

        for (int i = 1, j = 0; i < es.length; i++) {
            next[i] = es[i] == es[j] ? next[j] : j;
            while (j >= 0 && es[i] != es[j]) j = next[j];
            j++;
        }


        long pre = solve(s1);
        long ans = (solve(s2) - pre + M) % M;
        if (s1.indexOf(evil) == -1) ans++;
        return (int) (ans % M);

    }


    public long solve(String str) {
        dp = new long[str.length()][es.length][2];
        os = str.toCharArray();
        return dfs(0, 0, true);
    }


    char[] es;
    long[][][] dp;
    char[] os;
    int[] next;
    int M = 1000000007;

    public long dfs(int pos, int pre, boolean limit) {
        if (pre == es.length) return 0;
        if (pos == os.length) return 1;
        if (dp[pos][pre][limit ? 1 : 0] > 0) {
            return dp[pos][pre][limit ? 1 : 0];
        }
        char max = limit ? os[pos] : 'z';
        long res = 0;
        for (int i = 'a'; i <= max; i++) {
            int temp = pre;
            while (temp >= 0 && es[temp] != i) {
                temp = next[temp];
            }
            long t = dfs(pos + 1, temp + 1, limit && (i == max));
            res = res + t;
            res %= M;
        }
        dp[pos][pre][limit ? 1 : 0] = res;
        return res;
    }


}
