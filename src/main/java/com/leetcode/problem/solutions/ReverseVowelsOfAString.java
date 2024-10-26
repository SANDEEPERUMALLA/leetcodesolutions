package com.leetcode.problem.solutions;

import java.util.*;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
 * 345. Reverse Vowels of a String
 * Example 1:
 * <p>
 * Input: s = "IceCreAm"
 * <p>
 * Output: "AceCreIm"
 * <p>
 * Explanation:
 * <p>
 * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * <p>
 * Output: "leotcede"
 */


public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {

        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        List<Character> vowelsInString = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelsInString.add(s.charAt(i));
            }
        }

        int j = vowelsInString.size() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                sb.append(vowelsInString.get(j));
                j--;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();
        System.out.println(reverseVowelsOfAString.reverseVowels("IceCreAm"));
        System.out.println(reverseVowelsOfAString.reverseVowels("leetcode"));
        System.out.println(reverseVowelsOfAString.reverseVowels("e"));
        System.out.println(reverseVowelsOfAString.reverseVowels("m"));
        System.out.println(reverseVowelsOfAString.reverseVowels("ieo"));
        System.out.println(reverseVowelsOfAString.reverseVowels("ieo"));
        System.out.println(reverseVowelsOfAString.reverseVowels(""));
        System.out.println(reverseVowelsOfAString.reverseVowels("em"));
    }
}
