package com.Sorting.Question;

import java.util.Arrays;
import java.util.HashSet;
/*
Given an integer array nums, return true if any
 value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.
 */

class ContainsDuplicate_leetcode {
    public static void main(String[] args) {
        int[] arr={1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> check=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(check.contains(nums[i])){       // check that is there any similar element there or not
                return true;
            }
            check.add(nums[i]);
        }
        return false;
    }
    //M2
    public boolean containsDuplicate_2(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] ^ arr[i - 1]) == 0) return true;
        }
        return false;
    }

}