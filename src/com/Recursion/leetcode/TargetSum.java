package com.Recursion.leetcode;

class TargetSum {
    public int findTargetSumWays(int[] arr, int target) {
        return helper(arr,target,0);
    }

    private int helper(int[] arr, int target, int index) {
        if(index>=arr.length){
            return target==0 ? 1 : 0;
        }
        int left=helper(arr,target-arr[index],index+1);
        int right=helper(arr,target+arr[index],index+1);
        return left + right;
    }
}