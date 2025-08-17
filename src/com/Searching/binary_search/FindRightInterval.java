package com.Searching.binary_search;

import java.util.Arrays;

class FindRightInterval {
    public static void main(String[] args) {
        int[][] arr={{1,4},{2,3},{3,4}};
        System.out.println(Arrays.toString(findRightInterval(arr)));
    }
    public static int[] findRightInterval(int[][] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        // Answer array ko -1 se initialize kar rahe hain
        Arrays.fill(ans, -1);

        // Ek nayi array bana rahe hain jisme original indices ko store karenge aur start value ke according sort karenge
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = arr[i][0];
            intervals[i][1] = i;  // Original index ko store kar rahe hain
        }

        // Intervals ko start value ke basis par sort kar rahe hain
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Har interval ke liye right interval ko find kar rahe hain
        for (int i = 0; i < n; i++) {
            int end = arr[i][1];

            // Binary search kar rahe hain first interval ke liye jiska start >= arr[i][1]
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (intervals[mid][0] >= end) {
                    right = mid - 1;  // Chhota start interval dekh rahe hain
                } else {
                    left = mid + 1;  // Bara start interval chahiye
                }
            }

            // Agar left valid index hai, toh right interval mil gaya hai
            if (left < n) {
                ans[i] = intervals[left][1];  // Original index ko store kar rahe hain
            }
        }

        return ans;
    }
}