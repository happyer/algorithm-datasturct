package com.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chengxu03 on 2021/8/10.
 */
public class MergeBSTsCreateSingle {


    public static class TreeNode {
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


    public static void main(String[] args) {
        //[[2,1],[3,2,5],[5,4]]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
//        node2.left = node1;
//        node3.left = node2;
//        node3.right = node5;
        node5.left = node4;

        List<TreeNode> in =new ArrayList<>();
        in.add(node5);
        in.add(node3);
        MergeBSTsCreateSingle mergeBSTsCreateSingle = new MergeBSTsCreateSingle();
        mergeBSTsCreateSingle.canMerge(in);



    }


    private Map<Integer, List<TreeNode>> leaves = new HashMap<>();
    private Map<Integer, TreeNode> roots = new HashMap<>();

    public TreeNode canMerge(List<TreeNode> trees) {
        for (TreeNode tree : trees) {
            roots.put(tree.val, tree);
        }


        for (TreeNode tree : trees) {
            init(tree);
        }

        //find bst
        TreeNode bstRoot = null;
        for (TreeNode tree : trees) {
            if (!leaves.containsKey(tree.val)) {
                bstRoot = tree;
                break;
            }
        }

        if (bstRoot == null) {
            return null;
        }

        merge(bstRoot);

        if ( roots.size() == 1 && isValid(bstRoot, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return bstRoot;
        }
        return null;

    }


    private void  init(TreeNode tree){
        if (tree == null){
            return;
        }
        if (tree.left != null) {
            List<TreeNode> node = leaves.get(tree.left.val);
            if (node == null) node = new ArrayList<>();
            node.add(tree);
            leaves.put(tree.left.val, node);

        }
        if (tree.right != null) {
            List<TreeNode> node = leaves.get(tree.right.val);
            if (node == null) node = new ArrayList<>();
            node.add(tree);
            leaves.put(tree.right.val, node);
        }
        init(tree.left);
        init(tree.right);
    }

    private boolean isValid(TreeNode bstRoot, int min, int max) {
        if (bstRoot.val < min && bstRoot.val > max) {
            return false;
        }
        boolean l = true, r = true;
        if (bstRoot.left != null) {
            l = isValid(bstRoot.left, min, bstRoot.val);
        }
        if (bstRoot.right != null) {
            r = isValid(bstRoot.right, bstRoot.val, max);
        }
        return bstRoot.val > min && bstRoot.val < max && l && r;

    }

    private void merge(TreeNode bstRoot) {
        if (bstRoot == null) {
            return;
        }
        if (bstRoot.left != null) {
            if (roots.containsKey(bstRoot.left.val)) {
                bstRoot.left = roots.get(bstRoot.left.val);
                roots.remove(bstRoot.left.val);
            }
        }
        if (bstRoot.right != null) {
            if (roots.containsKey(bstRoot.right.val)) {
                bstRoot.right = roots.get(bstRoot.right.val);
                roots.remove(bstRoot.right.val);
            }
        }
        merge(bstRoot.left);
        merge(bstRoot.right);
    }


}
