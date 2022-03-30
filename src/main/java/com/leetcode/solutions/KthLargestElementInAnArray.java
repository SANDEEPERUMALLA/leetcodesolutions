package com.leetcode.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
    215. Kth Largest Element in an Array
    https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(value -> value));
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));;
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));;
    }
}
