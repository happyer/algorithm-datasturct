package com.alg;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack2 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            boolean found = false;
            for (int j = 0; j < nums2.length; j++) {
                if (found && nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    break;
                }
                if (nums2[j] == nums1[i]) {
                    found = true;
                }
            }
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            ans[j] = map.getOrDefault(nums1[j], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == c) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
