package com.alg;

public class RegularExpressionMatching {

    public static void main(String[] args) {

        String s = "aa";
        String p = "a*";

        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s, s.length() - 1, p, p.length() - 1);
    }

    /**
     * 通过 从后面往前面进行匹配
     * 当遇到 * 就取 * 前面的那个,然后继续比较 1 2 ..
     * 如果不能匹配,将x* 当作是一个空继续匹配
     * @param s
     * @param i
     * @param p
     * @param j
     * @return
     */
    private static boolean isMatch(String s, int i, String p, int j) {

        if (j == -1)
            if (i == -1)
                return true;
            else
                return false;

        if (p.charAt(j) == '*') {
            if (i > -1 && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
                //将 * 当作匹配1个以上
                if (isMatch(s, i - 1, p, j)) {
                    return true;
                }
            }
            //p 将*当作0 个
            return isMatch(s, i, p, j - 2);
        }
        if (i > -1 && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))) {
            return isMatch(s, i - 1, p, j - 1);
        }
        return false;
    }

}
