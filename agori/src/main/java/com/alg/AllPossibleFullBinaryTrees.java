package com.alg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengxu03 on 2021/9/13.
 */
public class AllPossibleFullBinaryTrees {


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

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0) return ans;
        if (n == 1) {
            TreeNode treeNode = new TreeNode(0);
            ans.add(treeNode);
            return ans;
        }
        for (int i = 1; i < n; i+=2) {
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(n - 1 - i);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(0);
                    node.left  = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}
