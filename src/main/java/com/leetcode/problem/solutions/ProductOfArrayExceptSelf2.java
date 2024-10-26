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
public class ProductOfArrayExceptSelf2 {

    public int[] productExceptSelf(int[] nums) {

        int totalArrayProduct = 1;

        int noOfZeroes = 0;
        for (int num : nums) {
            if (num == 0) {
                noOfZeroes++;
            } else {
                totalArrayProduct *= num;
            }
        }

        if (noOfZeroes > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }

        boolean zeroPresent = noOfZeroes == 1;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] == 0) ? totalArrayProduct : (zeroPresent ? 0 : totalArrayProduct / nums[i]);
        }

        return nums;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf2 productOfArrayExceptSelf = new ProductOfArrayExceptSelf2();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[]{2, 3, 4, 0, 6, 0})));
    }
}
