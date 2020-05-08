package com.alg;

public class BinaryTreeMaximumPathSum {


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxAns = Integer.MIN_VALUE;;

    public int maxPathSum(TreeNode root) {
        deepPathMax(root);
        return maxAns;
    }

    private int deepPathMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, deepPathMax(root.left));
        int right = Math.max(0, deepPathMax(root.right));
        maxAns = Math.max(maxAns, (left + right + root.val));
        // Returns the largest path starting with current node,
        // It could be the single node, or the node + left or right path
        return Math.max(left, right) + root.val;
    }
}
