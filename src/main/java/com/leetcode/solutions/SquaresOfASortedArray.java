package com.leetcode.solutions;

/*
    977. Squares of a Sorted Array
    https://leetcode.com/problems/squares-of-a-sorted-array/
 */

import java.util.Arrays;

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int l = 0;
        int r = n - 1;
        int index = n -1;
        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                result[index--] = nums[l] * nums[l];
                l++;
            } else {
                result[index--] = nums[r] * nums[r];
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[] { -7, -3, 2, 3, 11 })));

    }

}
