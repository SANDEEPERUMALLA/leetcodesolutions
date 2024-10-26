package com.leetcode.problem.solutions;

/**
 * https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 * 605. Can Place Flowers
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */


public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0 || flowerbed.length == 1) {

            if (flowerbed.length == 1) {
                if (flowerbed[0] == 0) {
                    return true;
                }
            }
            return n <= 0;
        }


        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {
            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else if (i - 1 > 0 && flowerbed[i - 1] == 0 && i + 1 < m && flowerbed[i + 1] == 0) {
                if (flowerbed[i] != 1) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (i == m - 1 && flowerbed[m - 2] == 0 && flowerbed[m - 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 3));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 1, 1, 1, 1}, 0));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 0}, 2));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0, 0, 0, 0, 1}, 2));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 2));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0, 1, 1, 0, 1}, 2));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1, 0, 0, 1, 0}, 1));
//        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1}, 0));
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0, 0}, 0));
    }
}
