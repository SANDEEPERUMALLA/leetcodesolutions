package com.leetcode.problem.solutions;


/**
 * https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * 392. Is Subsequence
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) {
            return true;
        }

        if (s.length() > t.length()) {
            return false;
        }

        int j = 0;
        char currentChar = s.charAt(j);

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == currentChar) {
                if (j == s.length() - 1) {
                    return true;
                }
                currentChar = s.charAt(j);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("aec", "abcde"));

    }
}
