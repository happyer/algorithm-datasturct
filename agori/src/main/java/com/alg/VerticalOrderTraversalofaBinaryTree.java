package com.alg;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chengxu03 on 2021/8/13.
 */
public class VerticalOrderTraversalofaBinaryTree {


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


    public static class Temp {
        private Integer row;
        private Integer val;

        public Temp(Integer row, Integer val) {
            this.row = row;
            this.val = val;
        }

        public Integer getRow() {
            return row;
        }

        public void setRow(Integer row) {
            this.row = row;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }


    private Map<Integer, List<Temp>> ans = new HashMap<>();

    private List<List<Integer>> s = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        ans.entrySet()
                .stream()
                .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
                .forEach(integerListEntry -> {

                    integerListEntry.getValue().sort(new Comparator<Temp>() {
                        @Override
                        public int compare(Temp o1, Temp o2) {
                            if (o1.row.equals(o2.row)) {
                               return o1.val.compareTo(o2.val);
                            }else {
                                return o1.val.compareTo(o2.val);
                            }

                        }
                    });
                    s.add(integerListEntry.getValue().stream().map(temp -> temp.val).collect(Collectors.toList()));
                });
        return s;
    }

    private void dfs(TreeNode cur, int row, int col) {
        if (cur == null) return;
        if (ans.containsKey(col)) {
            ans.get(col).add(new Temp(row, cur.val));
        } else {
            ans.put(col, new ArrayList<Temp>(Arrays.asList(new Temp(row, cur.val))));
        }
        if (cur.left != null) {
            dfs(cur.left, row + 1, col - 1);
        }
        if (cur.right != null) {
            dfs(cur.right, row - 1, col + 1);
        }
    }
}
