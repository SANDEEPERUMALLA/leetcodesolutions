package com.leetcode.solutions;

public class UniquePaths {


    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];
        paths[0][0] = 1;

        for (int j = 1; j < n; j++) {
            paths[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            paths[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
}
