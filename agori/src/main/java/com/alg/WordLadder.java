package com.alg;

import java.util.*;

/**
 * Created by chengxu03 on 2021/7/29.
 */
public class WordLadder {


    public static void main(String[] args) {


        //"hit"
        //"cog"
        //["hot","dot","dog","lot","log"]
       String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        List<List<String>> ans = findLadders(beginWord,endWord,wordList);
//        for (List<String> an : ans) {
//            for (String s : an) {
//                System.out.print(s+"\t");
//            }
//            System.out.println("");
//        }
        System.out.println("ans = " + ans);
    }


    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {


        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        if (!wordList.contains(endWord)) return new ArrayList<>();
        path.add(beginWord);
        visited.add(beginWord);
        help(beginWord, endWord, wordList, path, visited, ans);

        int small = Integer.MAX_VALUE;
        for (List<String> an : ans) {
            if (an.size() <= small){
                small = an.size();
            }
        }
        List<List<String>> finalAns = new ArrayList<>();
        for (List<String> an : ans) {
            if (an.size() == small){
                finalAns.add(an);
            }
        }


        if (finalAns.size()==0){
            return new ArrayList<>();
        }

        return finalAns;

    }

    private  static void help(String beginWord, String endWord, List<String> wordList, List<String> path, Set<String> visited, List<List<String>> ans) {
        if (beginWord.equals(endWord)){
            ans.add(new ArrayList<>(path));
            return;
        }
        //check condition
        for (String s : wordList) {
            if (!visited.contains(s) && check(beginWord,s)){
                path.add(s);
                visited.add(s);
                help(s,endWord,wordList,path,visited,ans);
                visited.remove(s);
                path.remove(path.size()-1);
            }
        }

    }


    //check is shortest transformation sequences
    private static boolean check(String beginWord, String s) {
            int diff = 0;
            for (int i = 0; i < beginWord.length() && diff < 2; i++) {
                if (beginWord.charAt(i) != s.charAt(i)) {
                    diff++;
                }
            }
            return diff == 1;
    }
}
