package com.alg;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public int majorityElement(int[] nums) {

        int cnt = 0;
        int cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cur = nums[i];
                cnt++;
            } else if (cur == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return cur;
    }

    public static List<Integer> majorityElement2(int[] nums) {
        int vote1 = 0;
        int vote2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                vote1++;
            } else if (candidate2 == num) {
                vote2++;
            } else if (vote1 == 0) {
                candidate1 = num;
                vote1++;
            } else if (vote2 == 0) {
                vote2++;
                candidate2 = num;
            } else {
                vote1--;
                vote2--;
            }
        }

        vote1 = 0;
        vote2 = 0;
        for (int num:nums){
            if (candidate1 == num){
                vote1++;
            }
            if (candidate2 == num){
                vote2++;
            }
        }

        List<Integer> ans  = new ArrayList<>();
        if (vote1 > nums.length/3){
            ans.add(candidate1);
        }
        if (vote2 > nums.length/3 && candidate1 != candidate2){
            ans.add(candidate2);
        }
        return ans;

    }

    public static void main(String[] args) {
        int a[] = new int[] {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("a = " + majorityElement2(a));
    }

}
