package com.leetcode.problem.solutions;

/**
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 * 1768. Merge Strings Alternately
 */
public class MergeStringsAlternatively {

    public enum WORDLENGTH {
        EQUAL,
        LEFT,
        RIGHT
    }

    public String mergeAlternately(String word1, String word2) {

        int n = Math.min(word1.length(), word2.length());
        WORDLENGTH flag = WORDLENGTH.EQUAL;
        if (word1.length() > word2.length()) {
            flag = WORDLENGTH.LEFT;
        } else if (word1.length() < word2.length()) {
            flag = WORDLENGTH.RIGHT;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (WORDLENGTH.LEFT == flag) {
            sb.append(word1, n, word1.length());
        } else if (WORDLENGTH.RIGHT == flag) {
            sb.append(word2, n, word2.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        MergeStringsAlternatively mergeAlternatively = new MergeStringsAlternatively();
        System.out.println(mergeAlternatively.mergeAlternately("", "b"));
    }
}
