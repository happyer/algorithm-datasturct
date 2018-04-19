package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chauncy on 2018/3/28.
 */
public class BinaryTree {

    class Node<T> {
        private final T data;
        private final Node left;
        private final Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node<T> reverse() {
            Node<T> newLeftSubtree = (right == null) ? null : right.reverse();
            Node<T> newRightSubtree = (left == null) ? null : left.reverse();
            return new Node<>(data, newLeftSubtree, newRightSubtree);
        }
    }

    public Tree.TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private Tree.TreeNode help(int[] preorder, int preStart, int preEnd, int[] inorder, int insStart, int inEnd) {
        return null;
    }

    private static int findIndex(int[] inorder, int inStart, int inEnd, int val) {
        while (inStart <= inEnd) {
            if (inorder[inStart] == val)
                return inStart;
            inStart++;
        }
        return -1;
    }

    public List<List<Integer>> pathSum(Tree.TreeNode root, int sum) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        backTrackingSum(ans, new ArrayList<Integer>(), root, sum);

        return ans;
    }

    private void backTrackingSum(List<List<Integer>> ans, ArrayList<Integer> integers, Tree.TreeNode root, int sum) {
        integers.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ans.add(new ArrayList<>(integers));
                return;
            }
            return;
        }
        if (root.left != null) {
            backTrackingSum(ans, integers, root.left, sum);
            integers.remove(integers.size() - 1);
        }
        if (root.right != null) {
            backTrackingSum(ans,integers,root.right,sum);
            integers.remove(integers.size()-1);
        }

    }

    Tree.TreeNode last;
    public void flatten(Tree.TreeNode root) {
        Tree.TreeNode orgL,orgR;
        if (root == null){
            return ;
        }
        if (last == null){
            last = root;
        }else {
            last.right = root;
            last.left = null;
            last = last.right;
        }
        orgL = root.left;
        orgR = root.right;
        flatten(orgL);
        flatten(orgR);
    }


    public void flatten2(Tree.TreeNode root) {

        if (root == null){
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = last;
        last = root;

    }

    int max =Integer.MIN_VALUE;
    public int maxPathSum(Tree.TreeNode root){
        if (root == null) return 0;
        int rootAsRes ,res;
        rootAsRes = res = root.val;
        int left  = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        if (left > 0){
            rootAsRes   += left;
        }
        if (right > 0){
            rootAsRes += right;
        }
        res+=Math.max(0,Math.min(right,left));
        max = Math.max(max,rootAsRes);
        max = Math.max(max,res);
        return res;
    }
}
