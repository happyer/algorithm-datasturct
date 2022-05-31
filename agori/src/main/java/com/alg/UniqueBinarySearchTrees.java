package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengxu03 on 2021/7/28.
 */
public class UniqueBinarySearchTrees {


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


    public List<TreeNode> generateTrees(int n) {

        return g(0, n);
    }

    private List<TreeNode> g(int start, int end) {

        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        if (end - start == 1) {
            list.add(new TreeNode(start, null, new TreeNode(end)));
            list.add(new TreeNode(end, new TreeNode(start), null));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = g(start, i - 1);
            List<TreeNode> rights = g(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode treeNode = new TreeNode(i, left, right);
                    list.add(treeNode);
                }
            }
        }
        return list;

    }
}
