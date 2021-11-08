package com.alg;

/**
 * Created by chengxu03 on 2021/9/18.
 */
public class FindKthBitinNthBinaryString {


    public char findKthBit(int n, int k) {
        if (k == 1){
            return '0';
        }
        int mid = 1 << (n - 1);

        if (k == mid){
            return '1';
        }else if (k <mid){
            return findKthBit(n-1,k);
        }else {
            k = mid *2 -k;
            return invert(findKthBit(n-1,k));
        }

    }

    private char invert(char kthBit) {
        return (char) ('0'+'1'-kthBit);
    }
}
