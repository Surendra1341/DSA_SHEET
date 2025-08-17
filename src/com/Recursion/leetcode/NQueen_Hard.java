package com.Recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

class NQueen_Hard {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        queen(board,0);
        return res;
    }
    private void queen(boolean[][] board,int r){
        if(r== board.length){
            display(board);
            return;
        }
        // placing the queen and check the every row and column
        for (int col = 0; col < board.length; col++) {
            //place  the queen if it is safe
            if(isSafe(board,r,col)){
                board[r][col]=true;
                queen(board,r+1);
                board[r][col]=false;
            }
        }
    }

    private  boolean isSafe(boolean[][] board, int r, int c) {
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

    private  void display(boolean[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]){
                    sb.append("Q");
                }else
                    sb.append(".");
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}