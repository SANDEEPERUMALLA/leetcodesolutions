package com.leetcode.problem.solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 * 238. Product of Array Except Self
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = leftProduct[i] * rightProduct[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
