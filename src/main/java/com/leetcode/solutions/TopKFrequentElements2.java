package com.leetcode.solutions;

import java.util.*;

/*
    347. Top K Frequent Elements
    https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elementToCount = new HashMap<>();
        for (int num : nums) {
            elementToCount.put(num, elementToCount.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> e : elementToCount.entrySet()) {
            priorityQueue.offer(e);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<Integer> l = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            l.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(l);
        return l.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TopKFrequentElements2 topKFrequentElements = new TopKFrequentElements2();
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 2)));
        nums = new int[] { 1 };
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 1)));
    }
}
