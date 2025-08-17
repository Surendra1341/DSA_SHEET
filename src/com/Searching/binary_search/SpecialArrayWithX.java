package com.Searching.binary_search;

import java.util.Arrays;

class SpecialArrayWithX {
    public static void main(String[] args) {
        int[] nums={0,4,3,0,4};
        System.out.println(specialArray(nums));
    }
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);

        // Edge case: If the array is empty, return -1.
        if (nums.length == 0) return -1;

        for (int i = 1; i <= nums.length; i++) {
            // Count how many numbers are greater than or equal to i.
            int count = 0;
            for (int num : nums) {
                if (num >= i) count++;
            }

            // If the count matches i, return i.
            if (count == i) {
                return i;
            }
        }
        return -1; // No valid "special" value found.
    }
}