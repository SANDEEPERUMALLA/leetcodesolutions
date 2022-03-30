package com.leetcode.solutions;

import java.util.*;
import java.util.stream.Collectors;

/*
    347. Top K Frequent Elements
    https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Element> elementToCount = new HashMap<>();
        for (int num : nums) {
            elementToCount.computeIfAbsent(num, Element::new).increment();
        }
        List<Element> sortedElementByFrequency = elementToCount.values().stream()
                .sorted(Comparator.comparingInt(Element::getFrequency).reversed()).collect(Collectors.toList());
        int[] topKFrequentElements = new int[k];
        for (int i = 0; i < k; i++) {
            topKFrequentElements[i] = sortedElementByFrequency.get(i).getNum();
        }
        return topKFrequentElements;
    }

    private static class Element {
        private final int num;
        private int frequency = 0;

        public Element(int num) {
            this.num = num;
        }

        public void increment() {
            frequency++;
        }

        public int getNum() {
            return num;
        }

        public int getFrequency() {
            return frequency;
        }
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 2)));
        nums = new int[]{1};
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, 1)));
    }
}
