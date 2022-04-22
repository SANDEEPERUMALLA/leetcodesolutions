package com.leetcode.solutions;

/*
    5. Longest Palindromic Substring
    https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (s.isEmpty()) {
            return s;
        }

        int n = s.length();
        boolean[][] table = new boolean[n][n];

        // substrings, of size 1
        int[] indices = { 0, 0 };
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        // substrings, of size 2
        for (int i = 0; i <= n - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                indices[0] = i;
                indices[1] = i + 1;
            }
        }

        int maxLength = Integer.MIN_VALUE;
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        indices[0] = i;
                        indices[1] = j;
                    }
                }
            }
        }

        return s.substring(indices[0], indices[1] + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("aaaaa"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("a"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("b"));
        System.out.println(longestPalindromicSubstring.longestPalindrome(""));
        System.out.println(longestPalindromicSubstring.longestPalindrome("aabbaa"));
    }
}
