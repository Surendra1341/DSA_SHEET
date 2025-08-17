package com.Sorting.Question;
/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */

class Kth_largest_element {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) return arr[high];


        // partition the arr and get pivot index
        int pivotIndex = partition(arr, low, high);

        // calculate the index of kth largest element
        int indexToFind = arr.length - k;

        if (pivotIndex == indexToFind) {
            return arr[pivotIndex];
        } else if (pivotIndex > indexToFind) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        //placing pivot correct position
        swap(arr, i, high);
        return i;

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}