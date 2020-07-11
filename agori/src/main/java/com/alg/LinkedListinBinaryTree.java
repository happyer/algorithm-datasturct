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
            if (seats[i] == 1) {
                left[i] = 0;
            } else if (i > 0) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = N - 1; i >= 0; --i) {
            if (seats[i] == 1) {
                right[i] = 0;
            } else if (i < N - 1) {
                right[i] = right[i + 1] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; ++i) {
            if (seats[i] == 0) {
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }
        return ans;

    }


    public static String addBinary(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int l1 = s1.length;
        int l2 = s2.length;
        if (l1 >= l2) {
            int temp = 0;
            int idx = l2 - 1;
            for (int i = s1.length - 1; i >= 0; i--) {
                if (idx >= 0) {
                    int f1 = s1[i] == '1' ? 1 : 0;
                    int f2 = s2[idx] == '1' ? 1 : 0;
                    temp += f1 + f2;
                    if (temp == 0) {
                        sb.append(0);
                    } else if (temp == 1) {
                        sb.append(1);
                        temp = 0;
                    } else if (temp == 2) {
                        sb.append(0);
                        temp = 1;
                    } else if (temp == 3) {
                        sb.append(1);
                        temp = 1;
                    }
                    idx--;
                } else {
                    int f1 = s1[i] == '1' ? 1 : 0;
                    temp += f1;
                    if (temp == 0) {
                        sb.append(0);
                    } else if (temp == 1) {
                        sb.append(1);
                        temp = 0;
                    } else if (temp == 2) {
                        sb.append(0);
                        temp = 1;
                    }

                }

            }
            if (temp == 1) {
                sb.append(1);
                temp = 0;
            }

        } else {
            int temp = 0;
            int idx = l1 - 1;
            for (int i = s2.length - 1; i >= 0; i--) {
                if (idx >= 0) {
                    int f1 = s2[i] == '1' ? 1 : 0;
                    int f2 = s1[idx] == '1' ? 1 : 0;
                    temp += f1 + f2;
                    if (temp == 0) {
                        sb.append(0);
                    } else if (temp == 1) {
                        sb.append(1);
                        temp = 0;
                    } else if (temp == 2) {
                        sb.append(0);
                        temp = 1;
                    } else if (temp == 3) {
                        sb.append(1);
                        temp = 1;
                    }
                    idx--;
                } else {
                    int f1 = s2[i] == '1' ? 1 : 0;
                    temp += f1;
                    if (temp == 0) {
                        sb.append(0);
                    } else if (temp == 1) {
                        sb.append(1);
                        temp = 0;
                    } else if (temp == 2) {
                        sb.append(0);
                        temp = 1;
                    }

                }
            }
            if (temp == 1){
                sb.append(1);
                temp = 0;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        int[] a = {1, 0, 0, 0, 1, 0, 1};
//        System.out.println("dominantIndex(a) = " + maxDistToClosest(a));

        System.out.println("addBinary(\"11\",\"10011\") = " + addBinary("11", "1111"));
        System.out.println("addBinary(\"11\",\"10011\") = " + addBinary("1111", "11"));

    }

}
