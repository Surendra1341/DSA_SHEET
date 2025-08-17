package com.Recursion.BackTracking;

public class NQueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board=new boolean[n][n];
        System.out.println(queen(board,0));
    }
    static int queen(boolean[][] board,int r){
        if(r== board.length){
            display(board);
            System.out.println();  // after display add new line
            return 1;
        }
        // placing the queen and check the every row and column
        int count=0;
        for (int col = 0; col < board.length; col++) {
            //place  the queen if it is safe
            if(isSafe(board,r,col)){
                board[r][col]=true;
                count+=queen(board,r+1);
                board[r][col]=false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {
        // for vertical row
        for (int i = 0; i < r; i++) {
            if(board[i][c]){
                return false;
            }
        }
        // diagonal left check
        int maxLeft=Math.min(r,c);
        for (int i = 0; i <= maxLeft; i++) {
            if(board[r-i][c-i]){            // both col an row is decrese
                return false;
            }
        }
        // diagonal right
        int maxRight=Math.min(r, board.length-c-1);
        for (int i = 0; i <= maxRight; i++) {
            if(board[r-i][c+i]){                // here row decrease and col++
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean element: row){
                if(element){                // true for placing queen otherwise false
                    System.out.print("Q  ");
                }else{
                    System.out.print("X  ");
                }
            }
            System.out.println();
        }
    }
}
