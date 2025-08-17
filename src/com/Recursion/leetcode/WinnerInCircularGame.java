package com.Recursion.leetcode;

class WinnerInCircularGame {
    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5));  // Example: Expected output: 1
    }

    public static int findTheWinner(int n, int k) {
        // We start with the base case where there's only one person (index 0 in 0-based indexing)
        int winner = 0;  // In 0-based index, when there's only 1 person, the winner is at index 0

        // Now, calculate the winner for increasing sizes of the circle
        // We solve the problem iteratively for each number of people from 2 to n
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }

        // Since we are using 0-based index, return winner + 1 to get the 1-based result
        return winner + 1;
    }
}