package com.alg;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/7/4
 */
public class LongestPalindrome {


    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(" = " + l.longestPalindrome("ccc"));

    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (cache.containsKey(c)) {
                cache.computeIfPresent(c, (character, integer) -> integer + 1);
            } else {
                cache.put(c, 1);
            }
        }

        AtomicInteger ans = new AtomicInteger();
        AtomicBoolean flag = new AtomicBoolean(false);
        cache.forEach((character, integer) -> {

            if (integer % 2 == 0) {
                ans.addAndGet(integer);

            } else {
                ans.addAndGet(integer-1);
                flag.set(true);
            }
        });
        if (flag.get()) {
            ans.addAndGet(1);
        }
        return ans.get();

    }
}
