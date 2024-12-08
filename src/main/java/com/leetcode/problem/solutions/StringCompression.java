package com.leetcode.problem.solutions;

/**
 * https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 * 443. String Compression
 * <p>
 * Example 1:
 * <p>
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * Example 2:
 * <p>
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * Example 3:
 * <p>
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 */
public class StringCompression {


    public int compress(char[] chars) {

        if (chars.length <= 1) {
            return chars.length;
        }

        int n = chars.length;
        int i = 0;
        int j = 0;
        char currentChar = chars[i];
        int count = 1;

        for (i = 1; i < n; i++) {
            if (chars[i] == currentChar) {
                count++;
                continue;
            }

            if (chars[i] != currentChar) {
                chars[j++] = currentChar;
                if (count > 1) {
                    char[] charArray = String.valueOf(count).toCharArray();
                    for (char c : charArray) {
                        chars[j++] = c;
                    }
                }
            }
            currentChar = chars[i];
            count = 1;
        }

        chars[j++] = currentChar;
        if (count > 1) {
            char[] charArray = String.valueOf(count).toCharArray();
            for (char c : charArray) {
                chars[j++] = c;
            }
        }

        return j;
    }

    public static void main(String[] args) {

        StringCompression stringCompression = new StringCompression();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(stringCompression.compress(chars));
        System.out.println(chars);

        chars = new char[]{'a', 'b', 'c'};
        System.out.println(stringCompression.compress(chars));

        chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(stringCompression.compress(chars));
        System.out.println(chars);

    }
}
