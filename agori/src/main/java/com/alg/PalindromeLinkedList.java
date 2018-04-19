package com.alg;

import java.util.PriorityQueue;

public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

//        System.out.println("isPalindrome(listNode1) = " + isPalindrome(listNode1));

//       ListNode reve=  reverse(listNode1);
//       while (reve !=null){
//           System.out.println("reve.val = " + reve.val);
//           reve = reve.next;
//       }
//        addTwoNumbers(listNode1, listNode4);

        System.out.println(reverseBetween(listNode1, 2, 4));
    }

    public static boolean isPalindrome(PalindromeLinkedList.ListNode head) {

        ListNode dumy = head;
        ListNode mid = getMid(head);
        ListNode tail = reverse(mid);

        while (tail != null) {
            if (tail.val != dumy.val) {
                return false;
            }
            dumy = dumy.next;
            tail = tail.next;
        }
        return true;

    }

    public static ListNode getMid(PalindromeLinkedList.ListNode node) {
        PalindromeLinkedList.ListNode slow = node;
        PalindromeLinkedList.ListNode fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        if (fast != null)
//            return slow.next;
        return slow;
    }

    public static ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode prev = ans;
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);
        int tmp = 0;
        while (rl1 != null || rl2 != null) {

            //check rl is null rl2 is null
            int a = tmp + rl1.val + rl2.val;
            if (a >= 10) {

                prev.next = new ListNode(tmp % 10);
                tmp = a / 10;

            } else {
                prev.next = new ListNode(a);
                tmp = 0;
            }

            //check
            rl1 = rl1.next;
            rl2 = rl2.next;
            prev = prev.next;
        }
        while (rl1 != null) {
            ans.next = new ListNode(rl1.val);
            rl1 = rl1.next;
        }
        while (rl2 != null) {
            ans.next = new ListNode(rl2.val);
            rl2 = rl2.next;
        }
        return ans.next;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }

        ListNode start = head;
        while (end.next.next != null) {
            start = start.next;
            end = end.next;
        }
        ListNode tmp = start.next;
        start.next = start.next.next;
        tmp.next = null;
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }
        ListNode prev = null;
        ListNode curr = null;
        ListNode head = null;
        while (!priorityQueue.isEmpty()) {
            curr = priorityQueue.poll();
            if (prev != null) {
                prev.next = curr;
            } else {
                head = curr;
            }
            if (curr.next != null) {
                priorityQueue.add(curr.next);
            }
            prev = curr;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next.next;
            int tmp = curr.val;
            curr.val = curr.next.val;
            curr.next.val = tmp;
            curr = next;
        }
        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode stop = null;
        ListNode curr = head;
        ListNode prev = null;
        int i = 0;
        while (i < k) {
            stop = curr.next;
            curr.next = prev;
            prev = curr;
            curr = stop;
            i++;
        }
        head.next = stop;
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        m--;
        n--;

        head.next = reverseBetween(head.next, m, n);
        return head;

    }

    private static ListNode tail = null;

    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            tail = head.next;
            return head;
        }
        n--;
        ListNode newHead = reverseN(head.next, n);
        head.next.next = head;
        head.next = tail;
        return newHead;

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null)
            return null;
        ListNode dumy = new ListNode(-1);
        ListNode current = head;
        ListNode noDuplicate = dumy;
        while (current != null) {
            if (current.next!= null && current.val == current.next.val){
                int tmp = current.val;
                while (current!= null && tmp == current.val){
                    current = current.next;
                }
            }else {
                noDuplicate.next = current;
                noDuplicate = noDuplicate.next;
                current = current.next;
            }
            noDuplicate.next = null;
        }
        return dumy.next;
    }

}
