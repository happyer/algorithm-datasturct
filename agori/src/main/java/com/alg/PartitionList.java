package com.alg;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/7/5
 */
public class PartitionList {


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

    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode beforeHead = before;
        ListNode after = new ListNode(0);
        ListNode afterHead = after;

        while (head != null) {
            if (head.val < x){
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}
