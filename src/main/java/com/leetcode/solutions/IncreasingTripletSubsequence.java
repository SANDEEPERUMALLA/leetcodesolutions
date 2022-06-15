package com.leetcode.solutions;

/*
    334. Increasing Triplet Subsequence
    https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] minLeft = new int[n];
        int[] maxRight = new int[n];

        minLeft[0] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], nums[i - 1]);
        }

        maxRight[n - 1] = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            if (minLeft[i] < nums[i] && nums[i] < maxRight[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        int[] nums1 = { 1, 2, 3, 4, 5 };
        System.out.println(increasingTripletSubsequence.increasingTriplet(nums1));
        int[] nums2 = { 5, 4, 3, 2, 1 };
        System.out.println(increasingTripletSubsequence.increasingTriplet(nums2));
        int[] nums3 = { 2, 1, 5, 0, 4, 6 };
        System.out.println(increasingTripletSubsequence.increasingTriplet(nums3));
    }
}
