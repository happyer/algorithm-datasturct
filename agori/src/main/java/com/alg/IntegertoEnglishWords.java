package com.alg;

/**
 * Created by chengxu03 on 2021/9/28.
 */
public class IntegertoEnglishWords {


    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                words = help(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num = num / 1000;
            i++;
        }
        return words.trim();

    }

    private String help(int i) {
        if (i == 0) {
            return "";
        }
        if (i < 20) {
            return LESS_THAN_20[i]+" ";
        } else if (i < 100) {
            return TENS[i / 10] +" "+ help(i % 10);
        } else {
            return LESS_THAN_20[i / 100] + " Hundred " + help(i % 100);
        }

    }
}
