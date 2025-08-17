package com.Recursion.leetcode;

import java.util.Arrays;
/*
Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer;
in other words, it is the product of some integer with itself. For example, 1, 4, 9,
and 16 are perfect squares while 3 and 11 are not.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
 */

class PerfectSquare {
    public static int numSquares(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1); // Initialize memoization array with -1 (meaning "uncomputed")
        return solve(n, arr);
    }

    public static int solve(int n, int[] arr) {
        // If we already have the result for this subproblem, return it
        if (arr[n] != -1) {
            return arr[n];
        }

        // Base case: if n is 0, no squares are needed
        if (n == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // We loop through all squares smaller than or equal to n
        for (int i = 1; i * i <= n; i++) {
            // For each square i*i, we solve the remaining problem n - i*i
            int res = 1 + solve(n - i * i, arr);
            // Keep track of the minimum result
            min = Math.min(min, res);
        }

        // Memoize the result for the current value of n
        arr[n] = min;
        return min;
    }
}