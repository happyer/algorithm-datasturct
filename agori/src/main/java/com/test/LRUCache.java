package com.test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    private final int capacity;


    private Map<String, LRUNode> map;


    private LRUNode head;
    private LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }


    public Object get(String key) {
        LRUNode lruNode = map.get(key);
        if (lruNode == null) return null;
        setHead(lruNode);
        return lruNode.value;
    }

    public void put(String key, Object value) {

        LRUNode node = null;

        if (map.containsKey(key)) {
            node = map.get(key);
            removeAndDelete(node, false);
        } else {
            if (map.size() + 1 > capacity) {
                removeAndDelete(tail, true);
            }
            node = new LRUNode(key, value);
            map.put(key, node);

        }
        setHead(node);

    }

    private void removeAndDelete(LRUNode node, boolean flag) {

        //check node is head
        if (node.prev != null) {
            node.prev.next = node.next;
        }else {
            head = node.next;
        }

        //check node is tail
        if (node.next!= null){
            node.next.prev = node.prev;
        }else {
            tail = node.prev;
        }

        node.prev = null;
        node.next = null;
        if (flag){
            map.remove(node.getKey());
        }
    }




    private void setHead(LRUNode node) {
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }


    private static class LRUNode {

        private String key;
        private Object value;
        private LRUNode prev;
        private LRUNode next;


        public LRUNode(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public LRUNode getPrev() {
            return prev;
        }

        public LRUNode getNext() {
            return next;
        }
    }
}
