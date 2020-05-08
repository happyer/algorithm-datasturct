package com.alg;

import java.util.HashMap;
import java.util.Map;

public class TrieSum {

    TrieNode root;

    public TrieSum() {
        root = new TrieNode();
    }

    class TrieNode {

        Map<Character, TrieNode> children;
        Integer val;
        boolean isWord;


        public TrieNode() {

            children = new HashMap<>();
            val = 0;
            isWord = false;
        }
    }


    public void insert(String key, int val) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                TrieNode trieNode = new TrieNode();
                curr.children.put(c, trieNode);
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
        curr.val = val;
    }

    public int sum(String prefix) {
        int res = 0;
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            }else {
                return 0;
            }
        }
        return dfsSum(curr);

    }


    private int dfsSum(TrieNode root) {
        int sum = 0;
        for (Character character : root.children.keySet()) {
            sum += dfsSum(root.children.get(character));
        }
        return sum + root.val;
    }


}
