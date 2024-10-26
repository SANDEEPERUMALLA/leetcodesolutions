package com.leetcode.problem.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 * 1431. Kids With the Greatest Number of Candies
 */
public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandies = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies kidsWithTheGreatestNumberOfCandies = new KidsWithTheGreatestNumberOfCandies();
        System.out.println(kidsWithTheGreatestNumberOfCandies.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }
}
