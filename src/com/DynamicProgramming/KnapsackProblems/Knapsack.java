package com.DynamicProgramming.KnapsackProblems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Knapsack {


    //03
    // recursive Knapsack
    int KnapsackRecursive(int []wt,int []val,int w,int n){
        //base condition  -> think of the smallest valid input
        if(n==0 || w==0) {
            return 0;
        }

        //input ko small kro

        // choice diagram->2 choice
        if(wt[n-1]<=w) {
        return Math.max(val[n-1]+KnapsackRecursive(wt,val,w-wt[n-1],n-1),KnapsackRecursive(wt,val,w,n-1) );
        }

        // else condition
        //not included
        return KnapsackRecursive(wt,val,w,n-1);
    }


    //04
    //memoization
    int[][] t= new int[102][1002];  // constraint--> max size

    void fill(){
        for (int[] i : t) {
            Arrays.fill(i,-1);
        }
    }
    int KnapsackRecursiveMemoization(int []wt,int []val,int w,int n){
       if(n==0 || w==0) {
           return 0;
       }


       //if already calculated
       if(t[n][w]!=-1){
           return t[n][w];
       }

        if(wt[n-1]<=w) {
            //store calculated ans
            t[n][w]= Math.max(val[n-1]+KnapsackRecursiveMemoization(wt,val,w-wt[n-1],n-1),KnapsackRecursiveMemoization(wt,val,w,n-1) );
            return t[n][w];
        }

        return t[n][w]= KnapsackRecursiveMemoization(wt,val,w,n-1);
    }


    // 5
    // top-down approach
    int knapsackTopDown(int []wt,int []val,int w,int n){
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
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j) {
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j] );
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][w];
    }


    //all 6 variation of knapsack

    //subset sum
    //Q1
    boolean subsetSum(int []arr,int sum){
        int n= arr.length;
        boolean[][] t= new boolean[n+1][sum+1];
        // initialize --> same as base condition
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
             if(i==0) t[i][j]=false;
             else if(j==0) t[i][j]=true;
            }
        }

        //iterative loop n-> i   w->j
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j) {
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    // equal sum partition problem
    //Q2
    //https://leetcode.com/problems/partition-equal-subset-sum/description/
    boolean EqualSumPartition(int[] arr){
        int n= arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        if(sum%2!=0) {
            return false;
        }
        //if sum even
        return subsetSum(arr,sum/2);
    }

    //count of subset of a given sum
    // Q3
    // edge case like sum=0  arr: [0]
    //then output should 2-> {},{0}  so if target sum is 0 return j -> start with 0
    public int countSubsetOfSum(int[] arr, int sum) {
        int n= arr.length;
        int[][] t= new int[n+1][sum+1];
        // initialize --> same as base condition
        for (int i = 0; i <= n; i++) t[i][0] = 1; // sum 0 is always possible
        for (int j = 1; j <= sum; j++) t[0][j] = 0; // no subset possible if array is empty


        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j) {
                    t[i][j]=t[i-1][j-arr[i-1]]+t[i-1][j];
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }


    //Q4
    //minimum subset sum difference
    int minSubsetSumDiff(int[] arr){
        int n= arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }

        //basically work with last row where all
        // element are included (0,range)-> (0, sum)
        // and then check all in last row if true mean at
        //last row ith sum possible and try to minimize range-2*s1


        //from this concept of subset Sum
        boolean[][] t= new boolean[n+1][sum+1];
        // initialize --> same as base condition
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) t[i][j]=false;
                else if(j==0) t[i][j]=true;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j) {
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }

        // check last row(0,sum)
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=(sum+1)/2;i++){
            if(t[n][i]){
                min=Math.min(min,sum-2*i);
            }
        }
        return min;

    }


    //Q5
    //Count the no. of subset of given difference
    int countSubsetSumDiff(int[] arr,int diff){
        int n= arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int s1 = (sum+diff)/2;
        return countSubsetOfSum(arr,s1);
    }


    //target sum
    //Q6
    int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int sum = 0;
        for (int num : arr) sum += num;

        // Check if (sum + target) is even and target is achievable
        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) return 0;

        int s1 = (sum + target) / 2;
        return countSubsetOfSum(arr, s1);
    }




}
