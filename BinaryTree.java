package com.souche;


/**
 * Created by chauncy on 2018/3/28.
 */
public class BinaryTree {


    class Node<T> {
        private final T data;
        private final Node left;
        private final Node right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node<T> reverse() {
            Node<T> newLeftSubtree = (right == null) ? null : right.reverse();
            Node<T> newRightSubtree = (left == null) ? null : left.reverse();
            return new Node<>(data, newLeftSubtree, newRightSubtree);
        }
    }


}
