package com.alg;

public class NumArray {

    int[] nums = null;


    static int BITree[];


    int getSum(int index) {
        int sum = 0; // Iniialize result

        // index in BITree[] is 1 more than
        // the index in arr[]
        index = index + 1;

        // Traverse ancestors of BITree[index]
        while (index > 0) {
            // Add current element of BITree
            // to sum
            sum += BITree[index];

            // Move index to parent node in
            // getSum View
            index -= index & (-index);
        }
        return sum;
    }

    public static void updateBIT(int n, int index,
        int val) {
        // index in BITree[] is 1 more than
        // the index in arr[]
        index = index + 1;

        // Traverse all ancestors and add 'val'
        while (index <= n) {
            // Add 'val' to current node of BIT Tree
            BITree[index] += val;

            // Update index to that of parent
            // in update View
            index += index & (-index);
        }
    }

    void constructBITree(int arr[], int n) {
        // Initialize BITree[] as 0
        for (int i = 1; i <= n; i++) {
            BITree[i] = 0;
        }

        // Store the actual values in BITree[]
        // using update()
        for (int i = 0; i < n; i++) {
            updateBIT(n, i, arr[i]);
        }
    }


    public NumArray(int[] nums) {
        int n = nums.length;
        BITree = new int[n];
        constructBITree(nums, n);
    }

    public void update(int i, int val) {
        updateBIT(nums.length, i, val);
    }

    public int sumRange(int i, int j) {
        return (getSum(j) - getSum(i));
    }
}
