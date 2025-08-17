package com.Recursion.easy;
/*
Given an integer num, return the number of steps to reduce it to zero.
        In one step, if the current number is even, you have to divide it by 2,
        otherwise, you have to subtract 1 from it.
*/


public class Steps_to_zero {
    public static void main(String[] args) {
        System.out.println(step(14));
    }

    private static int step(int n) {
        return helper(n,0);
    }

    private static int helper(int n, int s) {
        if(n==0){
            return s;
        }
        if(n%2==0){
            return helper(n/2,s+1);
        }
        return helper(n-1,s+1);
    }
}
