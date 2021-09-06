package com.alg;

/**
 * Created by chengxu03 on 2021/8/27.
 */
public class MergekSortedLists {


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

    public ListNode mergeKLists(ListNode[] lists) {
        return help(lists, 0, lists.length-1);
    }

    private ListNode help(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left < right){
            int mid = left + (right - left) / 2;
            ListNode l = help(lists, left, mid);
            ListNode r = help(lists, mid + 1, right);
            return merge(l, r);
        }else {
            return null;
        }

    }

    private ListNode merge(ListNode l, ListNode r) {

        if (l == null) return r;
        if (r == null) return l;
        if (l.val < r.val) {
            l.next = merge(l.next, r);
            return l;
        }else {
            r.next = merge(l,r.next);
            return r;
        }

    }
}
