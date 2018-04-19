package com.alg;

public class LongestPalindromicSubstring {

    /**
     * We define P(i,j)P(i,j) as following:
     *
     * P(i,j) = \begin{cases} \text{true,} &\quad\text{if the substring } S_i \dots S_j \text{ is a palindrome}\\
     * \text{false,} &\quad\text{otherwise.} \end{cases}P(i,j)={ true, false, ​
     *
     * if the substring S i ​ …S j ​ is a palindrome otherwise. ​
     *
     *
     * Therefore,
     *
     * P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j )P(i,j)=(P(i+1,j−1) and S i ​ ==S j ​ )
     *
     * The base cases are:
     *
     * P(i, i) = trueP(i,i)=true
     *
     * P(i, i+1) = ( S_i == S_{i+1} )P(i,i+1)=(S i ​ ==S i+1 ​ )
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int row = 0, col = 0;

        for (int i = s.length() - 2; i >= 0; i --){
            for (int j = i + 1; j <= s.length() - 1; j++){
                if ((s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[ i + 1 ][ j - 1 ])) {
                    dp[i][j] = true;
                    if (j - i + 1 > col - row + 1){
                        row = i;
                        col = j;
                    }
                }

            }
        }
        return s.substring(row, col + 1);

    }

    public static void main(String[] args) {
        String a = "cbbd";
        System.out.println("a = " + longestPalindrome(a));
    }

}
