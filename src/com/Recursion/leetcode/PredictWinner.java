package com.Recursion.leetcode;

class PredictWinner {
    public static void main(String[] args) {
        int[] arr = {1, 5, 233, 7};
        System.out.println(predictTheWinner(arr)); // Expected output: true
    }

    public static boolean predictTheWinner(int[] nums) {
        // We call the helper function starting from index 0 and index (nums.length - 1)
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    // Helper function that calculates the score difference between two players
    private static int helper(int[] arr, int start, int end) {
        // Base case: When there's only one element left, take it (this will be the last move)
        if (start == end) {
            return arr[start];
        }

        // Option 1: Player picks the start element, and the result depends on the remaining elements
        int pickStart = arr[start] - helper(arr, start + 1, end);

        // Option 2: Player picks the end element, and the result depends on the remaining elements
        int pickEnd = arr[end] - helper(arr, start, end - 1);

        // The player wants to maximize the score difference, so return the best option
        return Math.max(pickStart, pickEnd);
    }
}
