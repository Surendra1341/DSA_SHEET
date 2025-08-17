package com.Sorting.Question;

import java.util.Arrays;
/*
Given an integer array nums of length n and an integer target,
 find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

class Three_sum_closest {
    public static void main(String[] args) {
        int[] arr={-1,2,1,-4};
        System.out.println(threeSumClosest(arr,1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int diff=Integer.MAX_VALUE;
        int closest=0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start=i+1;
            int end= nums.length-1;
            while(start<end) {
                int sum=nums[i] + nums[start] + nums[end];
                if(sum==target){
                    return target;
                }
                if (Math.abs(sum-target)<diff){
                    diff=Math.abs(sum-target);
                    closest=sum;
                }
                if(target>sum) {
                    start++;
                } else {
                    end--;
                }
            }

        }
        return closest;
    }
}