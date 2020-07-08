package com.alg;

import java.util.Arrays;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/7/5
 */
public class LinkedListinBinaryTree {


    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return root.val == head.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }

    public static int dominantIndex(int[] nums) {

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                idx = i;
                max = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] * 2 > max && i != idx) {
                return -1;
            }
        }
        return idx;

    }


    public static int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i-1] + 1;
        }

        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N-1) right[i] = right[i+1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;

    }


    public static void main(String[] args) {
        int[] a = {1, 0, 0, 0, 1, 0, 1};
        System.out.println("dominantIndex(a) = " + maxDistToClosest(a));
    }

}
