package com.Arrays;

import java.util.Arrays;
/*
Given an integer n, return any array containing n unique integers such that they add up to 0.


 */
class Unique_N_SumZero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }
    public static int[] sumZero(int n) {
        int[] ans=new int[n];
        if(n%2==0){
            for (int i = 0; i < ans.length/2; i++) {
                ans[i]=i+1;
                ans[ans.length/2 +i]=-ans[i];
            }
        }else{
            ans[ans.length/2]=0;
            for (int i = 0; i < ans.length/2; i++) {
                ans[i]=i+1;
                ans[ans.length/2 +i]=-ans[i];
            }
        }
        return ans;
    }
}