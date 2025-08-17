package com.Recursion.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
 You may return the combinations in any order.
The same number may be chosen from candidates an unlimited
number of times. Two combinations are unique if the frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations
that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
 */

class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(arr, target, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void helper(int[] arr, int target, int sum, int start, List<Integer> internal, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(internal)); // Add a copy of the list to avoid mutation issues
            return;
        }

        for (int i = start; i < arr.length; i++) {
            sum += arr[i];
            if (sum <= target) {
                internal.add(arr[i]);
                helper(arr, target, sum, i, internal, ans); // Recurse with the same i to allow reuse of the current element
                internal.remove(internal.size() - 1); // Backtrack
            }
            sum -= arr[i]; // Undo the addition
        }
    }
}
