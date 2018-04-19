package com.alg;

public class BestTimeToBuyandSellStock {

    public static void main(String[] args) {

        int a[] = new int[] {7, 1, 5, 3, 6, 4};
        int b[] = new int[] {7, 6, 4, 3, 1};
        int c[] = new int[] {7, 1, 5, 3, 6, 4};
        
        int d[] = new int[]{1,2,3,4,5};

//        System.out.println(maxProfit3(a));
//        System.out.println(maxProfit3(b));
//        System.out.println(maxProfit3(c));
        System.out.println("maxProfit4(d) = " + maxProfit4(d));
        

    }

    public static int maxProfit(int[] prices) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res > 0 ? res : 0;
    }

    public static int maxProfit2(int[] prices) {

        if (prices.length == 1 || prices == null)
            return 0;

        int minIndex = 0;
        int currentMax = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            }
            currentMax = Math.max(currentMax, prices[i] - prices[minIndex]);
        }
        return currentMax;

    }

    public static int maxProfit3(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    /**
     * most two transaction
     *
     * @param prices
     * @return
     */
    public static int maxProfit4(int[] prices) {

        int[] cache = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int maxProfile = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfile = Math.max(prices[i] - min, maxProfile);
            cache[i] = maxProfile;
        }

        int maxTotal = 0;
        maxProfile = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i > 0; i--) {
            maxProfile = Math.max(maxProfile,prices[i]);
            maxTotal = Math.max(maxTotal,maxProfile-prices[i]+cache[i]);
        }

        return maxTotal;

    }

}

