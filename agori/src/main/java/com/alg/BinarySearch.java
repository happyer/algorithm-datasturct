package com.alg;

import java.util.Arrays;

public class BinarySearch {

    public int lengthOfLIS(int[] nums) {
        int[] ans = new int[nums.length];
        int len = 0;

        for (int num : nums) {

            int i = Arrays.binarySearch(ans, num);
            if (i < 0) {
                i = -(i + 1);
            }
            ans[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int number : numbers) {
            int i = binarySearch(numbers, 0, numbers.length, target - number);
            if (i < 0) {
                return null;
            }
            return new int[] {number, numbers[i]};
        }
        return null;
    }

    public int binarySearch(int[] src, int l, int r, int target) {

        while (l < r) {

            int mid = (l + r) >>> 1;
            int midVal = src[mid];
            if (target > midVal) {
                l = mid + 1;
            } else if (target < midVal) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
