package com.leetcode.problem.solutions;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }


    public static void main(String[] args) {

        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));


    }
}
