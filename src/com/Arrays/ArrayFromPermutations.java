package com.Arrays;
/*
Given a zero-based permutation nums (0-indexed),
build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.
length and return it.A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).


 */
public class ArrayFromPermutations {
    public int[] buildArray(int[] num) {
        int[] ans = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            // Ensure num[i] is a valid index
            if (num[i] >= 0 && num[i] < num.length) {
                ans[i] = num[num[i]];
            } else {
                // Handle out-of-bounds if necessary
                ans[i] = 0; // or some other default value
            }
        }
        return ans;
    }
}
