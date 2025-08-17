package com.Recursion.leetcode;
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells,
 where adjacent cells are horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
 */

class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board, "ABCCED")); // should return true
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] check = new boolean[board.length][board[0].length];

        // Start the search from every cell
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (helper(board, word, r, c, check, 0)) {
                    return true; // If we find the word, return true
                }
            }
        }
        return false; // Word not found
    }

    // Helper function for backtracking
    private static boolean helper(char[][] board, String word, int r, int c, boolean[][] check, int index) {
        // If we have matched the entire word, return true
        if (index == word.length()) {
            return true;
        }

        // Check if out of bounds or already visited
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || check[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        check[r][c] = true;

        // Explore all four directions (up, down, left, right)
        boolean found = helper(board, word, r + 1, c, check, index + 1) ||
                helper(board, word, r - 1, c, check, index + 1) ||
                helper(board, word, r, c + 1, check, index + 1) ||
                helper(board, word, r, c - 1, check, index + 1);

        // Unmark the cell for backtracking
        check[r][c] = false;

        return found;
    }
}
