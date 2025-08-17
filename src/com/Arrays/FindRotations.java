package com.Arrays;

import java.util.Arrays;
/*
Given two n x n binary matrices mat and target,
return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

Example 1:
Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
 */
class FindRotations {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
//        int[][] target = [[1,1,1],[0,1,0],[0,0,0]];
        int[][] target={{1,1,1},{0,1,0},{0,0,0}};
        System.out.println(findRotation(mat,target));

    }
    public static boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if(Arrays.deepEquals(mat,target)){
                return true;
            }
            mat=rotate(mat);
        }
        return false;
    }

    private static int[][] rotate(int[][] matrix) {
        int[][] ans=new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][matrix.length-1-i]=matrix[i][j];
            }
        }
return ans;
    }

}