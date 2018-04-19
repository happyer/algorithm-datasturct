package com.alg;

/**
 * Created by chauncy on 2018/3/28.
 */
public class SingleLink {


    private Node head;


    class Node {

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        int value;
        Node next;
    }


    public void add(int a) {
        Node node = new Node(a);
        if (head == null) {
            head = node;
            head.next = null;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = node;
        }
    }


    public int get() {
        Node newH = head.next;
        int value = head.getValue();
        head.next = null;
        head = newH;
        return value;
    }

    public void reverse() {
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head = prev;
    }

    public void print() {
        Node t = head;
        while (t != null) {
            System.out.println("t.getValue() = " + t.getValue());
            t = t.next;
        }
    }


    public static void main(String[] args) {
        SingleLink singleLink = new SingleLink();
        for (int i = 0; i < 10; i++) {
            singleLink.add(i);
        }
        singleLink.print();
        System.out.println(" ========reverse============= ");
        singleLink.reverse();
        singleLink.print();

    }

}
