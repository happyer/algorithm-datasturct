package com.alg;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int cnt = 0;
        for (int start = 0; cnt < nums.length; start++) {
            int current = start;
            int prev = nums[current];
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                current = next;
                cnt++;
            }
            while (current != start);
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp  = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end --;
        }
    }
}
