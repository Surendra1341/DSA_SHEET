package com.Arrays;



class Candy_135 {
    public int candy(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // Arrays to store the candies count from left to right and right to left
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize both left and right arrays with 1 (each child gets at least one candy)
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = left[i - 1] + 1; // Increment candy count if current element is greater than previous
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right[i] = right[i + 1] + 1; // Increment candy count if current element is greater than next
            }
        }

        // Final result: sum the maximum candies from both left and right directions
        int totalCandy = 0;
        for (int i = 0; i < n; i++) {
            totalCandy += Math.max(left[i], right[i]); // Take the max value from left and right
        }

        return totalCandy;
    }
}
