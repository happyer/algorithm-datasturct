package com.alg;

/**
 * Created by chengxu03 on 2021/9/15.
 */
public class FindtheWinneroftheCircularGame {


    public int findTheWinner(int n, int k) {

        return help(n, k) + 1;

    }

    private int help(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (help(n - 1, k) + k) % n;
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 16; i++) {
            System.out.println(i+"%4 = " + i%4);
        }
    }
}
