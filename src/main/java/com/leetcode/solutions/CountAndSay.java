package com.leetcode.solutions;

/*
    38. Count and Say
    https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i <= n - 1; i++) {
            str = convertToCountStr(str);
        }
        return str;
    }

    private String convertToCountStr(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder countStr = new StringBuilder();
        int count = 1;
        char currentCh = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != currentCh) {
                countStr.append(count); // count of  the character
                countStr.append(currentCh); // character
                count = 1;
                currentCh = str.charAt(i);
            } else {
                count++;
            }
        }

        countStr.append(count); // count of  the character
        countStr.append(currentCh); // character

        return countStr.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(1));
        System.out.println(countAndSay.countAndSay(2));
        System.out.println(countAndSay.countAndSay(3));
        System.out.println(countAndSay.countAndSay(4));
        System.out.println(countAndSay.countAndSay(5));
        System.out.println(countAndSay.countAndSay(6));
    }
}
