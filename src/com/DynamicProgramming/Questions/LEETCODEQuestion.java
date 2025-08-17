package com.DynamicProgramming.Questions;

import java.util.Arrays;

public class LEETCODEQuestion {


    //https://leetcode.com/problems/minimum-falling-path-sum
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] t = new int[n][n];
//        for (int[] row : t) Arrays.fill(row, -1);
//
//        int ans = Integer.MAX_VALUE;
//        for (int j = 0; j < n; j++) {
//            ans = Math.min(ans, dfs(matrix, 0, j, t));
//        }
//        return ans;


        //memo
        for(int i=0;i<n;i++)t[n-1][i] = matrix[n-1][i]; // copy the last row

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int down = t[i+1][j];

                int leftD = j>0?t[i+1][j-1]:Integer.MAX_VALUE/2;

                int rightD = j<n-1?t[i+1][j+1]:Integer.MAX_VALUE/2;

                t[i][j] =matrix[i][j]+ Math.min(down,Math.min(leftD,rightD));
            }
        }

        // now store all ans in first row


        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)ans = Math.min(ans,t[0][i]);
        return ans;
    }
    //recursive  -> TLE
    private int dfs(int[][] a, int i, int j, int[][] t) {

        if (j < 0 || j >= a[0].length) return Integer.MAX_VALUE / 2;
        if (i == a.length - 1) return a[i][j];
        if (t[i][j] != -1) return t[i][j];

        int down = dfs(a, i + 1, j, t);
        int leftDiag = dfs(a, i + 1, j - 1, t);
        int rightDiag = dfs(a, i + 1, j + 1, t);

        return t[i][j] = a[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
    }


    //https://leetcode.com/problems/jump-game-ii/
    public int jump(int[] nums) {
        int n = nums.length;
        int[] t = new int[n];
        Arrays.fill(t, -1);
        return solveJumpGame(nums, 0, t);
    }

    private int solveJumpGame(int[] nums, int i, int[] t) {
        int n = nums.length;
        if (i >= n - 1) return 0;
        if (t[i] != -1) return t[i];

        int ans = Integer.MAX_VALUE / 2; // overflow on +1
        int maxJump = nums[i];
        for (int j = 1; j <= maxJump && i + j < n; j++) {
            ans = Math.min(ans, 1 + solveJumpGame(nums, i + j, t));
        }
        return t[i] = ans;
    }






}
