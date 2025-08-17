package com.Recursion.BackTracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board={
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if(solve(board)){
            displayBoard(board);
        }else{
            System.out.println("cannot solve");
        }
    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyPlace = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyPlace = false;
                    break;
                }
            }
            //if i found a empty place then i not have to search
            if (emptyPlace == false) {
                break;
            }
        }

        if (emptyPlace==true) {
            return true;
            //sudoku solved
        }
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static void displayBoard(int[][] board) {
        for (int[] row: board){
            for ( int number: row){
                System.out.print(number+"  ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int r, int c, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == num) {      // checking col
                return false;
            }
            if (board[i][c] == num) {           // checking row
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = r - r % sqrt;
        int colStart = c - c % sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
