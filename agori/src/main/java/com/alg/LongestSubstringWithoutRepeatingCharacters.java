package com.alg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int i = 0;
        int j = 0;

        int ans = Integer.MIN_VALUE;

        Set<Character> set = new HashSet<>();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {

        int len = s.length();

        int ans = 0;
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0, j = 0; j < len; j++) {
            if (cache.containsKey(s.charAt(j))) {
                i = Math.max(cache.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            cache.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
