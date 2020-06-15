package com.alg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/11
 */
public class NarrayTree {



    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        bfs(root);
        return ans;
    }


    List<List<Integer>> ans  = new ArrayList<>();

    Queue<Node> q = new ArrayDeque();

    public void  bfs(Node root){
        q.offer(root);
        List<Integer> temp = new ArrayList<>();
        int v = q.size();
        while (!q.isEmpty()){
            Node node = q.poll();
            temp.add(node.val);

            if (node.children !=null || !node.children.isEmpty()){
                for (Node child : node.children) {
                    if (child != null){
                        q.offer(child);
                    }
                }
            }
            v--;
            if (v == 0){
                ans.add(new ArrayList<>(temp));
                temp.clear();
                v = q.size();
            }
        }
    }

}
