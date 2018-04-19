package com.alg;

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[left] == target) {
                return left;
            } else if (nums[mid] == target) {
                return mid;
            } else if (nums[right] == target) {
                return right;
            } else if (nums[left] > target) {
                if (nums[mid] > target && nums[mid] < nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] < target) {
                if (nums[mid] < target && nums[mid] > nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[] {2, 5, 6, 0, 0, 1, 2};
        System.out.println(search2(a, 0));
    }

    public static boolean search2(int[] nums, int target) {
        return bs(nums, target, 0, nums.length - 1);
    }

    private static boolean bs(int[] nums, int target, int l, int r) {
        if (l > r)
            return false;
        int mid = l + r / 2;
        if (nums[mid] == target)
            return true;
        else if (nums[l] >= nums[r])
            return bs(nums, target, l, mid - 1) || bs(nums, target, mid + 1, r);
        else if (nums[mid] > target)
            return bs(nums, target, l, mid - 1);
        else
            return bs(nums, target, mid + 1, r);
    }
}
