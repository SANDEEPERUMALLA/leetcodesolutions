package com.leetcode.solutions;

import java.util.Arrays;

/*
    75. Sort Colors
    https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid]  == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 0, 2, 1 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 0, 1, 2 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 0, 0, 1, 1, 2, 2 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 0 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 1 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 2 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 0, 2 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] { 2, 0 };
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
