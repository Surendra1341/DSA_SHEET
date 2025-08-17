package com.Arrays;
/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
 */
class Running_sum {
    public int[] runningSum(int[] nums) {
         int[] ans = new int[nums.length];
        int sum=0;


        for (int i = 0; i < nums.length; i++) {
           sum+=nums[i];
           ans[i]=sum;
    }
    return ans;
}}