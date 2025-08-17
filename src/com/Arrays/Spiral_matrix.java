package com.Arrays;

import java.util.Arrays;
import java.util.List;
/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
 */

class Spiral_matrix {
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(mat));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int bottom= matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        Integer[] ans= new Integer[matrix.length * matrix[0].length];
        int i=0;
        while (i!=ans.length){
            for (int j = left; j <=right && i!=ans.length ; j++) {
                ans[i]=matrix[top][j];
                i++;
            }
            for (int j = top; j <bottom && i!=ans.length ; j++) {
                ans[i]=matrix[j+1][right];
                i++;
            }
            for (int j = right-1; j>=left && i!=ans.length ; j--) {
                ans[i]=matrix[bottom][j];
                i++;
            }
            for (int j = bottom-1; j > top && i!=ans.length; j--) {
                ans[i]=matrix[j][left];
                i++;
            }
            top++;
            left++;
            right--;
            bottom--;

        }
        return Arrays.asList(ans);
    }
}