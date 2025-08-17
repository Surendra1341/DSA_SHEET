package com.Sorting.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j],
 nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */

class Three_sum {
    public static void main(String[] args) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] arr={-1,0,1,2,-1,-4};
        ans=threeSum(arr);
        for (List<Integer> list : ans){
            System.out.println(list);
        }

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to use the two-pointer technique

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for 'i' to avoid repeating triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    // Found a valid triplet
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // Skip duplicate elements for 'start' and 'end'
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    // Move both pointers after finding a valid triplet
                    start++;
                    end--;
                } else if (sum < 0) {
                    // If the sum is less than 0, move the 'start' pointer to the right to increase the sum
                    start++;
                } else {
                    // If the sum is greater than 0, move the 'end' pointer to the left to decrease the sum
                    end--;
                }
            }
        }

        return ans;
    }
}