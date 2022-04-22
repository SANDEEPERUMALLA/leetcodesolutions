package com.leetcode.solutions;

/*
    443. String Compression
    https://leetcode.com/problems/string-compression/
 */
public class StringCompression {

    public int compress(char[] chars) {

        if (chars.length == 1) {
            return 1;
        }

        char currentCh = chars[0];
        int count = 1;
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != currentCh) {
                index = addCountAndCharacterToArray(chars, index, currentCh, count);
                count = 1;
                currentCh = chars[i];
            } else {
                count++;
            }
        }

        index = addCountAndCharacterToArray(chars, index, currentCh, count);
        return index;
    }

    private int addCountAndCharacterToArray(char[] chars, int index, char currentCh, int count) {
        if (count > 1) {
            if (count > 9) {
                chars[index++] = currentCh;
                int c = reverse(count);
                while (c >= 9) {
                    chars[index++] = Character.forDigit(c % 10, 10);
                    c = c / 10;
                }
                chars[index++] = Character.forDigit(c, 10);
            } else {
                chars[index++] = currentCh;
                chars[index++] = Character.forDigit(count, 10);
            }

        } else {
            chars[index++] = currentCh;
        }

        return index;
    }

    public static int reverse(int count) {
        int revNum = 0;
        while (count != 0) {
            revNum = (revNum * 10) + (count % 10);
            count = count / 10;
        }
        return revNum;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        int compressedLength = stringCompression.compress(chars);
        System.out.println(compressedLength + " : " + new String(chars));
        char[] chars1 = { 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        compressedLength = stringCompression.compress(chars1);
        System.out.println(compressedLength + " : " + new String(chars1));
        char[] chars2 = { 'a', 'a', 'a', 'a', 'a', 'a',  'a', 'a',  'a', 'a'};
        compressedLength = stringCompression.compress(chars2);
        System.out.println(compressedLength + " : " + new String(chars2));
    }
}
