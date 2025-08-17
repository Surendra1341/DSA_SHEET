package com.Searching.binary_search;
//https://leetcode.com/problems/median-of-two-sorted-arrays
//hard
class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] arr = new int[nums1.length + nums2.length];
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            } else {
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < nums1.length) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            arr[k] = nums2[j];
            j++;
            k++;
        }
        int n = arr.length;
        if(n==0) return (double)0;
        if (n % 2 == 0) {
            return ((arr[n / 2 - 1]) + (arr[n / 2])) / 2.0;
        }
        return (double)arr[(n + 1) / 2];

    }
}