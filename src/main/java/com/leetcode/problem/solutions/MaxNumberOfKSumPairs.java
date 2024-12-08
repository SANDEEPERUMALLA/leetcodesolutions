package com.leetcode.problem.solutions;

import java.util.HashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
    1679. Max Number of K-Sum Pairs

    You are given an integer array nums and an integer k.

    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

    Return the maximum number of operations you can perform on the array.



    Example 1:

    Input: nums = [1,2,3,4], k = 5
    Output: 2
    Explanation: Starting with nums = [1,2,3,4]:
    - Remove numbers 1 and 4, then nums = [2,3]
    - Remove numbers 2 and 3, then nums = []
    There are no more pairs that sum up to 5, hence a total of 2 operations.
    Example 2:

    Input: nums = [3,1,3,4,3], k = 6
    Output: 1
    Explanation: Starting with nums = [3,1,3,4,3]:
    - Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.


 */
public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> remaningSumToIndexMap = new HashMap<>();
        int maxNumberOfOperations = 0;
        for (int num : nums) {
            if (remaningSumToIndexMap.containsKey(num)) {
                Integer count = remaningSumToIndexMap.get(num);
                if (count > 0) {
                    maxNumberOfOperations++;
                    count--;
                    if (count == 0) {
                        remaningSumToIndexMap.remove(num);
                    } else {
                        remaningSumToIndexMap.put(num, count);
                    }
                }
            } else {
                Integer c = remaningSumToIndexMap.getOrDefault(k - num, 0);
                remaningSumToIndexMap.put(k - num, c + 1);
            }
        }
        return maxNumberOfOperations;
    }


    public static void main(String[] args) {
        MaxNumberOfKSumPairs maxNumberOfKSumPairs = new MaxNumberOfKSumPairs();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(maxNumberOfKSumPairs.maxOperations(nums, 5));

        nums = new int[]{3, 1, 3, 4, 3};
        System.out.println(maxNumberOfKSumPairs.maxOperations(nums, 6));

        nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(maxNumberOfKSumPairs.maxOperations(nums, 2));

        nums = new int[]{2, 2, 2, 3, 1, 1, 4, 1};
        System.out.println(maxNumberOfKSumPairs.maxOperations(nums, 4));

        nums = new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2};
        System.out.println(maxNumberOfKSumPairs.maxOperations(nums, 3));


    }
}
