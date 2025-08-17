package com.Recursion.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the
same combination twice, and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
 */

class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }

    private static void helper(int target, int k, int start, List<Integer> internal, List<List<Integer>> ans) {
        // If the combination is valid (size is k and target is 0), add it to the answer list
        if (target == 0 && internal.size() == k) {
            ans.add(new ArrayList<>(internal)); // Add a copy to avoid mutation issues
            return;
        }

        // Loop over possible numbers (1 to 9)
        for (int i = start; i <= 9; i++) {
            // If the current number exceeds the target, break early (no valid combinations possible)
            if (i > target) break;

            // If we already have k elements, no need to add more, so we break
            if (internal.size() == k) break;

            internal.add(i);  // Include the number in the combination
            helper(target - i, k, i + 1, internal, ans);  // Recurse with reduced target and next number
            internal.remove(internal.size() - 1);  // Backtrack by removing the last element
        }
    }
}