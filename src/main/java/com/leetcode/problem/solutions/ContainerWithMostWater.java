package com.leetcode.problem.solutions;

/**
 * https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75
 * 11. Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, (r - l) * h);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater.maxArea(heights));


    }
}
