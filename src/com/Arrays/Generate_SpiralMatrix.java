package com.Arrays;

import java.util.Arrays;
/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4
 */
class Generate_SpiralMatrix {
    public static void main(String[] args) {
        int[][] ans= new int[3][3];
ans=generateMatrix(3);
        for (int i = 0; i < 3; i++) {

            System.out.println(Arrays.toString(ans[i]));
        }
    }
    public static int[][] generateMatrix(int n) {
        int top=0;
        int bottom= n-1;
        int left=0;
        int right=n-1;
        int[][] ans= new int[n][n];
        int i=1;
        while (i<=n*n){
            for (int j = left; j <=right && i<=n*n ; j++) {
                ans[top][j]=i;
                i++;
            }
            for (int j = top; j <bottom && i<=n*n ; j++) {
                ans[j+1][right]=i;
                i++;
            }
            for (int j = right-1; j>=left && i<=n*n ; j--) {
               ans[bottom][j]=i;
                i++;
            }
            for (int j = bottom-1; j > top && i<=n*n; j--) {
                ans[j][left]=i;
                i++;
            }
            top++;
            left++;
            right--;
            bottom--;

        }
        return ans;
    }
}