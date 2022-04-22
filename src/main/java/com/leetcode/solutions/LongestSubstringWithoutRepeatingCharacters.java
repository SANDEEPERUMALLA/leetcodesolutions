package com.leetcode.solutions;

/*
    3. Longest Substring Without Repeating Characters
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) {
            return 0;
        }

        int[] charsCount = new int[256];
        int[] charsIndex = new int[256];

        int maxLength = Integer.MIN_VALUE;

        int start = 0;
        char ch = s.charAt(0);
        int chIndex = ch;
        charsCount[chIndex]++;
        charsIndex[chIndex] = 0;
        int j = 1;
        for (; j < s.length(); j++) {
            ch = s.charAt(j);
            chIndex = ch;
            charsCount[chIndex]++;
            if (charsCount[chIndex] > 1) {
                if (j - start > maxLength) {
                    maxLength = j - start;
                }
                int prevCharIndex = charsIndex[chIndex];
                for (int i = start; i <= prevCharIndex; i++) {
                    charsCount[s.charAt(i)]--;
                }
                start = prevCharIndex + 1;
            }
            charsIndex[chIndex] = j;
        }

        if (j - start > maxLength) {
            maxLength = j - start;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abababa"));
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcdee"));
    }
}
