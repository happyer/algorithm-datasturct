package com.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BackTracking {

    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {

        if (S == null || S.length() == 0)
            return ans;
        backtracking(S, 0, "");
        return ans;
    }

    private void backtracking(String s, int i, String s1) {
        if (s.length() == i) {
            ans.add(s1);
        }
        char a = s.charAt(i);
        if (Character.isDigit(a)) {
            backtracking(s, i + 1, s1 + a);
        } else {
            backtracking(s, i + 1, s1 + Character.toUpperCase(a));
            backtracking(s, i + 1, s1 + Character.toLowerCase(a));
        }
    }

    static List<List<Integer>> comAns = new ArrayList<>();
    static List<Integer> comTmp = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        comBacktracking(candidates, target, 0, 0);
        return comAns;
    }

    private static void comBacktracking(int[] candidates, int target, int start, int currSum) {
        if (currSum == target) {
            comAns.add(new ArrayList<>(comTmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (currSum + candidates[i] > target)
                break;
            comTmp.add(candidates[i]);
            int sum = currSum + candidates[i];
            comBacktracking(candidates, target, i, sum);
            comTmp.remove(comTmp.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        result.add(new ArrayList<>());
        subTracking(nums, 0, result, numList);
        return result;
    }

    private void subTracking(int[] nums, int start, List<List<Integer>> result, List<Integer> numList) {
        if (start >= nums.length)
            return;
        int val = nums[start];
        numList.add(val);
        subTracking(nums, start + 1, result, numList);
        result.add(new ArrayList<>(numList));
        numList.remove(numList.size() - 1);
        subTracking(nums, start + 1, result, numList);
    }

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfsExist(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsExist(int row, int col, int index, char[][] board, String word) {
        if (checkBound(row, col, board) == -1 ||
            visited[row][col] ||
            word.charAt(index) != board[row][col]) {
            return false;
        }

        //set visited
        visited[row][col] = true;
        if (index == word.length() - 1) {
            return true;
        }

        index++;
         /* down, right, up, left search */
        if (dfsExist(row + 1, col, index, board, word) ||
            dfsExist(row, col + 1, index, board, word) ||
            dfsExist(row - 1, col, index, board, word) ||
            dfsExist(row, col - 1, index, board, word)) {
            return true;
        }
        /* current position is wrong, backtracking */
        visited[row][col] = false;
        return false;

    }

    private int checkBound(int row, int col, char[][] board) {

        if (row == -1 || row == board.length || col == -1 || col == board[0].length) {
            return -1;
        }
        return 0;
    }

    public List<String> findWords(char[][] board, String[] words) {
        return Arrays.stream(words).filter(s -> exist(board, s)).collect(Collectors.toList());
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        sumKBacktringk(n, 0, 1, result, numList, k);
        return result;
    }

    private static void sumKBacktringk(int n, int curr, int start, List<List<Integer>> result, List<Integer> list,
        int k) {
        if (curr == n && k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (curr > n)
            return;
        if (k == 0)
            return;
        if (start > 9)
            return;
        for (int i = start; i <= 9; i++) {
            list.add(i);
            sumKBacktringk(n, curr + i, i + 1, result, list, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static boolean isMatch(String s, String p) {
        return isMatchHelp(s, 0, p, 0);
    }

    private static boolean isMatchHelp(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length())
            return true;
        if (j == p.length())
            return false;
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (p.charAt(j) == '*') {
            return isMatchHelp(s, i + 1, p, j) || isMatchHelp(s, i, p, j + 1);
        } else {
            if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                return isMatchHelp(s, i + 1, p, j + 1);
            }
            return false;
        }

    }

    private static boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[m][n] = true;
        for (int j = n - 1; j >= 0; --j)
            if (p.charAt(j) == '*')
                f[m][j] = true;
            else
                break;

        // DP
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (p.charAt(j) == '*')
                    f[i][j] = f[i][j + 1] || f[i + 1][j];
                else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
                    f[i][j] = f[i + 1][j + 1];
            }
        }

        return f[0][0];
    }

    public static void main(String[] args) {
//        int a[] = {8, 7, 4, 3};
//        combinationSum(a, 11);
//        System.out.println(comAns);
        //System.out.println("--" + combinationSum3(3, 9));
        System.out.println(isMatch("abcd", "a*?d"));
    }
}
