package com.alg;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by chauncy on 2019/3/21.
 */
public class ConsistentHash {


    static class Node {
        private int nodeNum;

        public Node(int num) {
            this.nodeNum = num;
        }

        @Override
        public String toString() {
            return "real node:" + nodeNum;
        }
    }

    //使用tree map 刚好可以进行排序
    private TreeMap<Long, Node> circle = new TreeMap<Long, Node>();

    //真是的节点
    private List<Node> realNodes = new ArrayList<Node>();


    public static Long getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).longValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void addNode(Node node) {
        realNodes.add(node);
        //get hash value
        Long hashVal = getMD5(node.toString());
        circle.put(hashVal, node);

    }

    public void removeNode(Node node) {
        realNodes.remove(node);
        Long nodeKey = getMD5(node.toString());
        circle.remove(nodeKey);
    }

    public Node getNode(String key) {
        Long keyMd5 = getMD5(key);
        SortedMap<Long, Node> nodes = circle.tailMap(keyMd5);
        Long k = null;

        if (nodes.isEmpty()) {
            //not hit
            //get first
            k = circle.firstKey();
        } else {
            k = nodes.firstKey();
        }
        return circle.get(k);

    }



    public static void main(String[] args) {
        ConsistentHash h = new ConsistentHash();
        h.addNode(new Node(1));
        h.addNode(new Node(2));
        for (int i = 0; i < 50; i++) {
            h.getNode("" + i);
            System.out.println(i + "--->" + h.getNode("" + i));
        }
    }



}
