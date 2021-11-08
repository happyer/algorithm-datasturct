package com.alg;

/**
 * Created by chengxu03 on 2021/9/24.
 */
public class ReorderList {


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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }


        //fast slow

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //cut 2 segment
        prev.next = null;

        ListNode head2 = reverse(slow);


        merge(head, head2);

    }

    private void merge(ListNode head, ListNode head2) {
        while (head != null) {
            ListNode next  = head.next;
            head.next = head2;
            head = head2;
            head2 = next;
        }
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


}
