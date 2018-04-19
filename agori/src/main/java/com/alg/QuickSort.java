package com.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chauncy on 2018/3/28.
 */
public class QuickSort {

    public static void main(String[] args) {
        int a[] = {5, 4, 2, 6, 8, 7, 9, 0, 2, 1};
        int a2[] = {5, 4, 2, 6, 8, 7, 9, 0, 2, 1};

//        sort(a, 0, a.length - 1);
//        sort2(a2, 0, a2.length - 1);
//
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] != a2[i]) {
//                System.out.println(a[i] + "--" + a2[i]);
//                break;
//            }
//        }

        int[] a3 = new int[] {3, 2, 1, 5, 6, 4};

        //1 2 2 3 3 4 5 5 6
        int[] a4 = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int ans = findKthLargest(a3, 0, a3.length - 1, a3.length - 2);
//        int ans = findKthLargest(a4, 0, a4.length - 1, a4.length - 4);
//        printArrray(a4);

        int[] a5 = new int[] {0, 2, 1};

        int[][] ma = new int[][] {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        searchMatrix2(ma, 5);

        String diffWays = "3-4*5";
        //diffWaysToCompute(diffWays);

        int[] reverse = new int[] {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        reversePairs(reverse);

    }

    public static void qsort(int a[], int l, int u) {
        int pivot, i, j;
        if (l < u - 1) {
            pivot = i = l;
            j = u;
            while (true) {
                while (i < u && a[++i] < a[pivot])
                    ;
                while (j >= l && a[pivot] < a[--j])
                    ;
                if (j < i)
                    break;
                exchange(a, i, j);
            }
            exchange(a, pivot, j);
            qsort(a, l, j);
            qsort(a, i, u);
        }
    }

    public static void exchange(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public static void printArrray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[i] = " + a[i] + "\t");
        }

    }

    static int val;

    public static int findKthLargest(int[] arr, int left, int right, int smallIndex) {
        if (left > right) {
            return -1;
        }
        int partition = partition(arr, left, right);
        if (partition == smallIndex) {
            return arr[partition];
        } else if (partition > smallIndex) {
            return findKthLargest(arr, left, partition - 1, smallIndex);
        } else if (partition < smallIndex) {
            return findKthLargest(arr, partition + 1, right, smallIndex);
        }
        return -1;
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static void sort2(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition2(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * @param a
     * @param low
     * @param high
     */
    static int partition2(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                exchange(a, i, j);

            }
        }
        exchange(a, i, low);
        return i + 1;
    }

    public static List<Integer> countSmaller(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ans.add(getSmallCount(nums[i], i, nums));
        }
        return ans;
    }

    public static int getSmallCount(int target, int startIndex, int[] nums) {
        int count = 0;
        if (startIndex >= nums.length - 1) {
            return 0;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (target > nums[i]) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> countSm(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = binSearch(temp, nums[i]);
        }

        temp.clear();

        for (int i = 0; i < nums.length; i++) {
            temp.add(ans[i]);
        }
        return temp;
    }

    private static int binSearch(List<Integer> temp, int target) {
        int l = 0;
        int r = temp.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int m = temp.get(mid);
            if (m < target) {
                l = mid + 1;
            } else if (m >= target) {
                r = mid - 1;
            }
        }
        temp.add(l, target);
        return l;

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int r = row - 1;
        int c = 0;
        while (r >= 0 && c < col) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                c++;
            } else {
                r--;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length - 1;
        for (int i = 0; i <= row; i++) {
            int res = Arrays.binarySearch(matrix[i], target);
            if (res < 0) {
                continue;
            } else {
                return true;
            }
        }
        return false;

    }

    public static int binSearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int a = arr[mid];
            if (target > a) {
                l = mid + 1;
            } else if (target < a) {
                r = mid - 1;
            } else {
                return l;
            }
        }
        return -1;
    }

    public static List<Integer> diffWaysToCompute(String input) {
        if (input == null) {
            return new ArrayList<Integer>();
        }

        return helper(input, 0, input.length() - 1);
    }

    private static Map<Character, List<Integer>> cache = new HashMap<>();

    private static List<Integer> helper(String input, int start, int end) {
        List<Integer> result = new ArrayList<Integer>();

        //if the currrent substring is a number, return
        try {
            result.add(Integer.parseInt(input.substring(start, end + 1)));
            return result;
        }
        //if not, do the parsing by the following
        catch (NumberFormatException e) {

        }

        for (int operatorIndex = start; operatorIndex <= end; operatorIndex++) {
            char currChar = input.charAt(operatorIndex);
            if (currChar == '+' || currChar == '-' || currChar == '*') {
                //recursively compute all possible results from other sides of current operator
                List<Integer> left = helper(input, start, operatorIndex - 1);
                List<Integer> right = helper(input, operatorIndex + 1, end);

                //combine all possible results
                for (int leftValue : left) {
                    for (int rightValue : right) {
                        int newValue;
                        char operator = input.charAt(operatorIndex);
                        if (operator == '+') {
                            newValue = leftValue + rightValue;
                        } else if (operator == '-') {
                            newValue = leftValue - rightValue;
                        } else {
                            newValue = leftValue * rightValue;
                        }
                        result.add(newValue);
                    }
                }
            }
        }

        return result;

    }

    public List<Integer> diffWaysToCompute2(String src) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < src.length(); i++) {
            char op = src.charAt(i);
            if (op == '+' || op == '-' || op == '*') {

                String part1 = src.substring(0, i);
                String part2 = src.substring(i + 1);
                List<Integer> left = diffWaysToCompute(part1);
                List<Integer> right = diffWaysToCompute(part2);
                for (Integer leftVal : left) {
                    for (Integer rightVal : right) {
                        switch (op) {
                            case '+':
                                ans.add(leftVal + rightVal);
                                break;
                            case '-':
                                ans.add(leftVal - rightVal);
                                break;
                            case '*':
                                ans.add(rightVal * leftVal);
                                break;
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(src));
        }
        return ans;

    }

    public static int reversePairs(int[] nums) {
        int cnt = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if ((nums[i]>>1)  >   nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
