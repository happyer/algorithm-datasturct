package com.alg;

/**
 * Created by chengxu03 on 2021/8/31.
 */
public class ShortestPalindrome {


    public static void main(String[] args) {
        String s = "aacecaaa";
        ShortestPalindrome sp = new ShortestPalindrome();
        int[] n = sp.getNext(s);
        int[] tab = sp.getTable(s);
        for (int i : n) {
            System.out.print(i + "\t");
        }
        System.out.println(" ======= ");
        for (int i : tab) {
            System.out.print(i + "\t");
        }

    }


    public String shortestPalindrome(String s) {

        String reverse = new StringBuilder(s).reverse().toString();
        String newStr = s + "#" + reverse;


        int[] next = getNext(newStr);
        return s.substring(next[newStr.length() - 1]) + s;

    }

    private int[] getNext(String s) {

        int[] next = new int[s.length()];

        int index = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(index)) {
                next[i] = next[i - 1] + 1;
                index++;
            }
            index = next[i - 1];
            while (index > 0 && s.charAt(index) != s.charAt(i)) {
                index = next[index - 1];
            }
            if (s.charAt(index) == s.charAt(i)) {
                index++;
            }
            next[i] = index;
        }
        return next;

    }

    public int[] getTable(String s) {
        //get lookup table
        int[] table = new int[s.length()];

        //pointer that points to matched char in prefix part

        int index = 0;
        //skip index 0, we will not match a string with itself
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i)) {
                //we can extend match in prefix and postfix
                table[i] = table[i - 1] + 1;
                index++;
            } else {
                //match failed, we try to match a shorter substring

                //by assigning index to table[i-1], we will shorten the match string length, and jump to the
                //prefix part that we used to match postfix ended at i - 1
                index = table[i - 1];

                while (index > 0 && s.charAt(index) != s.charAt(i)) {
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index - 1];
                }

                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if (s.charAt(index) == s.charAt(i)) {
                    //if match, then extend one char
                    index++;
                }

                table[i] = index;
            }

        }

        return table;
    }

}
