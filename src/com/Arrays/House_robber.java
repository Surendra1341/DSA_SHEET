package com.Arrays;

import com.Funtions_04.Maximum;
/*
You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed, the only constraint stopping
  you from robbing each of them is that adjacent houses have security systems connected and it will
 automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house,
 return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:
 */
class House_robber {
    public static void main(String[] args) {
        int[] arr={2,7,9,3,1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {
         int prevno=0;
        int prevyes=0;
        for(int n:nums){
            int temp = prevno;
            prevno = Math.max(prevno,prevyes);
            prevyes=n+temp;
        }
        return Math.max(prevno,prevyes);
    }
}