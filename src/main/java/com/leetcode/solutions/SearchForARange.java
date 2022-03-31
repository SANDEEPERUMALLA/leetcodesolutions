package com.leetcode.solutions;

import java.util.Arrays;

/*

 */
public class SearchForARange {

    /*
        34. Find First and Last Position of Element in Sorted Array
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[] { findFirstOccurrence(nums, target), findLastOccurrence(nums, target) };
    }

    private int findFirstOccurrence(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high  = mid - 1;
                }

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        return -1;
    }

    private int findLastOccurrence(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (nums[mid] == target ) {
                if(mid == n - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    low  = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchForARange searchForARange = new SearchForARange();
        System.out.println(Arrays.toString(searchForARange.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
        System.out.println(Arrays.toString(searchForARange.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
        System.out.println(Arrays.toString(searchForARange.searchRange(new int[] { 1, 2, 3, 4 }, 2)));
        System.out.println(Arrays.toString(searchForARange.searchRange(new int[] { 1, 2, 2, 2 }, 2)));
        System.out.println(Arrays.toString(searchForARange.searchRange(new int[] { 1, 1, 1, 2 }, 1)));
        System.out.println(Arrays.toString(searchForARange.searchRange(new int[] { 1 }, 1)));
        System.out.println(Arrays.toString(searchForARange.searchRange(new int[] {}, 0)));

    }
}
