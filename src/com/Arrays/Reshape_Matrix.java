package com.Arrays;

import java.util.Arrays;
/*
In MATLAB, there is a handy function called reshape which can reshape an m x n matrix
into a new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing
the number of rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original
matrix in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal,
 output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
 */

class Reshape_Matrix {

    public static void main(String[] args) {
        int[][] mat={{1,2},{3,4}};
        System.out.println(matrixReshape(mat,1,4));
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ans=new int[r][c];
       int outer_col=0;
       int outer_row=0;
       if(r*c!= mat.length* mat[0].length) return mat;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(outer_col<c) {
                    ans[outer_row][outer_col] = mat[i][j];
                    outer_col++;
                }
                if(outer_col>=c){
                    outer_col=0;
                    outer_row++;
                }
            }
        }
return ans;
    }
}