package com.kuaishou;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private static class TrieNode {
        public char val;
        public boolean isWord;
        public Integer index;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }


    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word, int index) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
            ws.val = c;

        }
        ws.isWord = true;
        ws.index = index;
    }

    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }


    public static class StringIndex {
        public String str;
        public Integer index;

        @Override
        public String toString() {
            return "str=" + str + "\tidx=" + index;
        }
    }

    public List<StringIndex> list() {
        List<StringIndex> ans = new ArrayList<>();
        help(root, new ArrayList<>(), ans);
        return ans;
    }

    private void help(TrieNode root, List<Character> temp, List<StringIndex> ans) {
        if (root == null) return;
        if (root.index != null) {
            StringIndex stringIndex = new StringIndex();
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : temp) {
                stringBuilder.append(character);
            }
            stringIndex.str = stringBuilder.toString();
            stringIndex.index = root.index;
            ans.add(stringIndex);
            return;
        }




        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                temp.add(root.children[i].val);
                help(root.children[i], temp, ans);
                temp.remove(temp.size() - 1);
            }
        }


    }

    public static void main(String[] args) {
        Trie obj = new Trie();
//        obj.insert("word", 1);
//        boolean param_2 = obj.search("word");
//        boolean param_3 = obj.startsWith("wor");
//        System.out.println(param_2);
//        System.out.println(param_3);

        String w = "word";
        for (int i = 0; i < w.length(); i++) {
            String str = w.substring(i);
            obj.insert(str,i);
        }

        List<StringIndex> list = obj.list();
        for (StringIndex stringIndex : list) {
            System.out.println("stringIndex = " + stringIndex);
        }

    }
}
