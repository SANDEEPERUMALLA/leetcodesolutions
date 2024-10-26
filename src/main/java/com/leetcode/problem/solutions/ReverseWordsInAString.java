package com.leetcode.problem.solutions;


import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * 151. Reverse Words in a String
 * <p>
 * Example 1:
 * <p>
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (i == 0) {
                result.append(words[i]);
            } else {
                result.append(words[i]).append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
//        System.out.println(reverseWordsInAString.reverseWords("the sky is blue"));
        System.out.println(reverseWordsInAString.reverseWords("  hello world  "));
        System.out.println(reverseWordsInAString.reverseWords("a good   example"));
    }
}
