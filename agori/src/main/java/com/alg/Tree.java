package com.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> tmp = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return tmp;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> r = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                r.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            tmp.add(r);

        }

        Collections.reverse(tmp);
        return tmp;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return create(nums, 0, nums.length - 1);
    }

    private static TreeNode create(int[] nums, int i, int j) {
        if (i < 0 || j < 0 || i > j || i > nums.length || j > nums.length)
            return null;
        if (i == j) {
            return new TreeNode(nums[i]);
        }

        int mid = i + j << 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = create(nums, i, mid - 1);
        node.right = create(nums, mid + 1, j);
        return node;

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return false;

        int ll = getLevel(root.right);
        int rl = getLevel(root.left);
        if (Math.abs(ll - rl) > 1) {
            return false;
        }
        if (isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    private static int getLevel(TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (right == null)
            return 0;
        queue.offer(right);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            cnt++;
        }
        return cnt;
    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return 0;
        queue.offer(root);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                if (treeNode.left == null && treeNode.right == null) {
                    return cnt;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

        }
        return cnt;

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> res = new ArrayList<>();
        treePath(root, "", res);
        return res;
    }

    private void treePath(TreeNode root, String path, List<String> res) {

        if (root == null)
            return;
        if (path.length() == 0) {
            path += root.val;
        } else {
            path = path + "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            res.add(path);
        }
        treePath(root.left, path, res);
        treePath(root.right, path, res);

    }

    public int sumOfLeftLeaves(TreeNode root) {

        return sumLeft(root, true);
    }

    private int sumLeft(TreeNode root, boolean b) {
        if (root == null)
            return 0;
        if (b && root.left == null && root.right == null) {
            return root.val;
        }
        return sumLeft(root.left, true) + sumLeft(root.right, false);
    }

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        sumRoot(root, 0);
        return sum;
    }

    private void sumRoot(TreeNode root, int curr) {
        if (root == null)
            return;
        curr = curr << 1 | root.val;
        if (root.left == null && root.right == null) {
            sum += curr;
        }
        sumRoot(root.left,curr);
        sumRoot(root.right,curr);
    }



    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        TreeNode ll = trimBST(root.left,L,R);
        TreeNode rr = trimBST(root.right,L,R);
        if (L <= root.val && root.val <= R){
            root.left = ll;
            root.right = rr;
            return root;
        }else if (root.val < L){
            return rr;
        }else {
            return ll;
        }


    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        //List<List<Integer>> rs = levelOrderBottom(treeNode1);
        System.out.println("rs = " + isBalanced(treeNode1));
    }
}
