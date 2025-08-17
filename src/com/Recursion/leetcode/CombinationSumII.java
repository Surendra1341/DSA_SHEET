package com.Recursion.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique
combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
 */

class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(arr, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);  // Sorting helps in pruning duplicate combinations
        List<List<Integer>> ans = new ArrayList<>();
        helper(arr, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void helper(int[] arr, int target, int start, List<Integer> internal, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(internal));  // Add valid combination to the result
            return;
        }

        for (int i = start; i < arr.length; i++) {
            // Skip duplicates: if the current number is the same as the previous one, skip it
            if (i > start && arr[i] == arr[i - 1]) continue;

            // Skip if the number exceeds the target
            if (arr[i] > target) break;

            internal.add(arr[i]);  // Include arr[i] in the combination
            helper(arr, target - arr[i], i + 1, internal, ans);  // Recurse with reduced target and next index
            internal.remove(internal.size() - 1);  // Backtrack
        }
    }
}