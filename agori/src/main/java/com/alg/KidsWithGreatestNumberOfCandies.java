package com.alg;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }
        List<Boolean> b = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                b.add(Boolean.TRUE);
            } else {
                b.add(Boolean.FALSE);
            }
        }
        return b;
    }
}
