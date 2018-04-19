package com.alg;

public class UglyNumber {

    public int nthUglyNumber(int n) {
        int [] ans  = new int[n];
        int k  = 0;
        ans[k++] = 1;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        while (k < n){
            ans[k] = Math.min(ans[i1]*2,Math.min(ans[i2]*3,ans[i3]*5));
            if (ans[k] == ans[i1]*2){
                i1++;
            }
            if (ans[k] == ans[i2]*2){
                i2++;
            }
            if (ans[k] == ans[i3]*2){
                i3++;
            }
            k++;
        }

        return ans[n-1];
    }
}
