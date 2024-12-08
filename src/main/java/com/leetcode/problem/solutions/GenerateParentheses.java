package com.leetcode.problem.solutions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    https://leetcode.com/problems/generate-parentheses/description/
    22. Generate Parentheses

    Example 1:

    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    Example 2:

    Input: n = 1
    Output: ["()"]

 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        generateParenthesisInternal(n, "(", result, 1, 0);
        return result;
    }

    private void generateParenthesisInternal(int n, String str, List<String> result, int openCount, int closedCount) {

        if (str.length() == 2 * n) {
            result.add(str);
            return;
        }
        if (openCount < n) {
            generateParenthesisInternal(n, str + "(", result, openCount + 1, closedCount);
        }

        if (closedCount < n && closedCount < openCount) {
            generateParenthesisInternal(n, str + ")", result, openCount, closedCount + 1);
        }

    }

    public static void main(String[] args) {

        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(1));
    }
}
