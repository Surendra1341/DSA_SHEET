package com.Arrays;
/*
There is an m x n matrix that is initialized to all 0's.
There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to
 perform some increment operations on the matrix.For each location indices[i], do both of the following
Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

Example 1
Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
 */
class CellsWithOddValue {
    public static void main(String[] args) {
        int[][] arr = {{0, 1}, {1, 1}};
        System.out.println(oddCells(2, 3, arr));
    }

    public static int oddCells(int m, int n, int[][] indices) {

        int[][] mat = new int[m][n];


        for (int x = 0; x < indices.length; x++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == indices[x][0]) {
                        mat[i][j]++;
                    }
                    if (j == indices[x][1]) {
                        mat[i][j]++;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;

    }
}