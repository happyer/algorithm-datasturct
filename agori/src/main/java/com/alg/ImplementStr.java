package com.alg;

public class ImplementStr {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int t=0;
        do {
            int d1 = a.charAt(i--) == '1' ? 1 : 0;
            int d2 = b.charAt(j--) == '1' ? 1 : 0;

            t += d1 + d2;
            int m = t % 2;
            sb.append(m);
            t = (t-m)/2;
        }
        while (t > 0 && i>=0 && j>=0);
        return sb.reverse().toString();
    }
}
