package com.DynamicProgramming.KnapsackProblems;

public class UnboundedKnapsack {




    int unboundedKnapsackTopDown(int []wt,int []val,int w,int n){
        if(n==0 || w==0) {
            return 0;
        }
        // initialize --> same as base condition
        int[][] t= new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i==0 || j==0) {
                    t[i][j]=0;
                }
            }
        }

        //iterative loop n-> i   w->j
        //if item taken then we can take more than one times so->X
        // if not means processed
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j) {
                    t[i][j]=Math.max(val[i-1]+t[i][j-wt[i-1]]  ,  t[i-1][j] );
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][w];
    }


    //rod cutting problem
    int rodCutting(int []length,int []price,int N){
        int n=length.length;
        if(n==0 || N==0) {
            return 0;
        }
        // initialize --> same as base condition
        int[][] t= new int[n+1][N+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<N+1;j++){
                if(i==0 || j==0) {
                    t[i][j]=0;
                }
            }
        }

        //iterative loop n-> i   N->j
        //if item taken then we can take same length more than one so->X(unprocessed)
        // if not means processed
        for(int i=1;i<n+1;i++){
            for(int j=1;j<N+1;j++){
                if(length[i-1]<=j) {
                    t[i][j]=Math.max(price[i-1]+t[i][j-length[i-1]]  ,  t[i-1][j] );
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][N];
    }

// coin change pattern
    //https://leetcode.com/problems/coin-change-ii/description/
    int coinChange(int[] coins, int sum) {
        int n=coins.length;
        int[][] t= new int[n+1][sum+1];
        // initialize --> same as base condition
        for (int i = 0; i <= n; i++) t[i][0] = 1;
        for (int j = 1; j <= sum; j++) t[0][j] = 0;

        //iterative loop n-> i   w->j
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j) {
                    t[i][j]= t[i-1][j] + t[i][j-coins[i-1]] ;
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }


    // coin change 2
//    https://leetcode.com/problems/coin-change/
    int coinChangeII(int[] coins, int sum) {
        int n=coins.length;
        int[][] t= new int[n+1][sum+1];
        //initialization
        for(int j=1;j<=sum;j++){
            //first row
            t[0][j]=Integer.MAX_VALUE-1;

            //second row initialization
            if(j%coins[0]==0) {
                t[1][j]= j/coins[0];
            }else {
                t[1][j]= Integer.MAX_VALUE-1;
            }
        }
        // 1st column -> sum =0 min. coins -> 0
        for (int i = 0; i <= n; i++){
                t[i][0]=0;
        }

        // here two choice include -> unprocessed also +1 for include a coin
        // not include- > processed
        // we want minimum b/w them
        for(int i=2;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j) {
                    t[i][j]=Math.min(1+t[i][j-coins[i-1]] , t[i-1][j] );
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum]==Integer.MAX_VALUE?-1:t[n][sum];
    }

    



}
