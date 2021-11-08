package com.alg;


/**
 * Created by chengxu03 on 2021/9/10.
 */
public class ReverseString {


    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        boolean a = r.isPowerOfTwo(3);
        System.out.println("a = " + a);
    }

    private static void reverse(char str[], int i, int j) {
        if (i >= j) {
            return;
        }
        char t = str[i];
        str[i] = str[j];
        str[j] = t;
        reverse(str, i + 1, j - 1);
    }


    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }


    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n % 2 != 0){
            return false;
        }
        return isPowerOfTwo(n / 2);
    }


}
