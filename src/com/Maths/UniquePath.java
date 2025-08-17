package com.Maths;
//https://leetcode.com/problems/unique-paths
class UniquePath {
    public int uniquePaths(int r, int c) {
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < c; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[r - 1][c - 1];
    }
}