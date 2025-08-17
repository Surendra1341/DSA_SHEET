package com.Arrays;

import java.util.Arrays;
//https://leetcode.com/problems/largest-number
class LargestNumber {
    public String largestNumber(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            String ab = a + "" + b;
            String ba = b + "" + a;
            return ba.compareTo(ab);
        });

        if (nums[0] == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (Integer num : nums) {
            result.append(num);
        }

        return result.toString();
    }
}