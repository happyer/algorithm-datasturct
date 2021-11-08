package com.alg;

/**
 * Created by chengxu03 on 2021/10/13.
 */
public class WorldPar {


    public boolean isMatch(String s, String p) {
        return help(s, p, 0, 0);
    }

    private boolean help(String s, String p, int si, int pi) {

        if (si > s.length()) return false;
        if (pi > s.length()) return false;

        if (si == s.length() && pi == p.length()) {
            return true;
        }
        if (s.charAt(si) == p.charAt(pi)) {
            return help(s, p, si + 1, pi + 1);
        }
        if (p.charAt(pi) == '?') {
            return help(s, p, si + 1, pi + 1);
        }
        if (p.charAt(pi) == '*') {
            int i = si;
            while (s.charAt(i) != p.charAt(pi + 1)) {
                i++;
                if (i > s.length()) {
                    return false;
                }
            }
            return help(s, p, i, pi);
        }
        return false;
    }
}
