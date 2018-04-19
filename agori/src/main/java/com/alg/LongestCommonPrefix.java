package com.alg;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strings = new String[] {"floqw", "flow"};
//        System.out.println("longestCommonPrefix(strings) = " + longestCommonPrefix(strings));

        String a = "floqw";
        String b = "flow";

        int  bi = b.indexOf(a);
        System.out.println("bi = " + bi);
//        System.out.println("bi = " + a.substring(0,bi));
    }

    static class Node {
        private boolean isEnd;
        private Character character;
        private Map<Character, LongestCommonPrefix.Node> children = new HashMap<>();

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, Node> children) {
            this.children = children;
        }
    }

    static class TireTree {

        private Node root;

        public TireTree() {
            this.root = new Node();
        }

        public void add(String str) {
            Node currentOld = root;
            int i = 0;
            while (i < str.length() && currentOld.children.containsKey(str.charAt(i))) {

                currentOld = currentOld.children.get(str.charAt(i));
                i++;

            }
            if (i == str.length()) {
                currentOld.isEnd = true;
            } else {
                Node parNode = currentOld;
                while (i < str.length()) {
                    char val = str.charAt(i);
                    Node node = new Node();
                    node.setCharacter(val);
                    parNode.children.put(val, node);
                    parNode = node;
                    if (i == str.length() - 1) {
                        node.isEnd = true;
                    }
                    i++;
                }
            }

        }

        public boolean find(String str) {
            Node curr = root;
            int i = 0;
            while (i < str.length() && curr.children.containsKey(str.charAt(i))) {
                curr = curr.children.get(str.charAt(i));
                i++;
            }
            if (i == str.length() && curr.isEnd) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * LCP(S1..SN) = LCP(LCP(LCP(S1,S2)S3)SN)
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
