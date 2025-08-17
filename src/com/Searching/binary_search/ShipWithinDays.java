package com.Searching.binary_search;

import java.lang.reflect.Array;
import java.util.Arrays;

import java.util.Arrays;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days
class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        // Initialize left as the heaviest package and right as the total weight of all packages
        for (int weight : weights) {
            left = Math.max(left, weight); // max weight of a single package
            right += weight; // total sum of all weights
        }

        int ans = 0;
        // Binary search for the optimal weight capacity
        while (left <= right) {  // Corrected the loop condition to include right boundary
            int mid = left + (right - left) / 2; // mid is the candidate weight capacity

            // Check if it's possible to ship all packages with 'mid' weight capacity
            if (canShip(weights, days, mid)) {
                ans = mid;  // If we can ship within the days, save the result
                right = mid - 1; // Try smaller capacity
            } else {
                left = mid + 1; // If we can't, try larger capacity
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0; // Current weight in the current day
        int dayCount = 1; // We start with the first day

        for (int weight : weights) {
            // If adding the current package exceeds the capacity, we need a new day
            if (currentWeight + weight > capacity) {
                dayCount++; // Ship on a new day
                currentWeight = weight; // Start new day with this package
                if (dayCount > days) {
                    return false; // Too many days, capacity is not sufficient
                }
            } else {
                currentWeight += weight; // Add the current package to the current day
            }
        }

        return true; // If we can ship in 'days' or less
    }
}
