package com.alg;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chengxu03 on 2020/7/22.
 */
public class WordBreak {


    Set<String> dic = null;

    public List<List<String>> ans = new ArrayList<>();


    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        WordBreak wordBreak = new WordBreak();
        wordBreak.wordBreak(s,wordDict);

        for (List<String> an : wordBreak.ans) {
            System.out.println("an = " + an);
        }


        wordBreak.ans.clear();

        String s2 = "pineapplepenapple";
        List wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

        wordBreak.wordBreak(s2,wordDict2);
        for (List<String> an : wordBreak.ans) {
            System.out.println("an2 = " + an);
        }






    }


    public List<String> wordBreak(String s, List<String> wordDict) {

        dic = new HashSet<>(wordDict);

        help(s, 0, new ArrayList<String>());


        return ans.stream().map(strings -> strings.stream().collect(Collectors.joining(" "))).collect(Collectors.toList());


    }

    private void help(String s, int pos, ArrayList<String> strings) {

        if (pos == s.length()) {
            ans.add(new ArrayList<>(strings));
            return;
        }
        for (int start = pos; start < s.length()+1; start++) {
            String temp  = s.substring(pos,start);
            if (dic.contains(temp)) {
                strings.add(temp);
                help(s,start,strings);
                strings.remove(strings.size()-1);
            }
        }

    }


}
