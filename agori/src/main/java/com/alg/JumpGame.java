package com.alg;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2022/1/8
 */
public class JumpGame {


    public int[] nums;

    public boolean canJump(int[] nums) {
        this.nums = nums;
        return dp(0, nums.length - 1);
    }


    public boolean dp(int i, int len) {
        if (i >= len) {
            return true;
        }
        if (i + nums[i] >= len) {
            return true;
        }
        for (int j = 1; j < nums[i] + 1; j++) {
            if (dp(i + j, len)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 0, 4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(" = " + jumpGame.canJump(a));
    }

}
