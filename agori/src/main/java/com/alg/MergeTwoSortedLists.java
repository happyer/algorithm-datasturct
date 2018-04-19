package com.alg;

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(1);
        ListNode cur = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode listNode = new ListNode(l1.val);
                cur.next = listNode;
                l1 = l1.next;
            } else {
                ListNode listNode = new ListNode(l2.val);
                cur.next = listNode;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return res.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        ListNode res = removeElements(listNode1,3);
        while (res != null) {
            System.out.println("res = " + res.val);
            res = res.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;

        ListNode prev = head;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            if (prev.val != head.val) {
                prev.next = head;
                prev = head;
            }
            head.next = null;
            head = next;
        }
        return res;

    }

    public static ListNode removeElements(ListNode head, int val) {
       ListNode curr = head;
       ListNode prev = head;

       while (curr!= null){
           if (curr.val == val){
                if (curr == head){
                    head = head.next;
                }else {
                    while (curr.next != null && curr.next.val == val){
                        curr = curr.next;
                    }
                    prev.next = curr.next;
                }

           }
           prev = curr;
           curr = curr.next;
       }
       return head;
    }

}
