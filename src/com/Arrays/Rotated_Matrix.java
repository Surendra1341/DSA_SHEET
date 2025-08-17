package com.Arrays;

import java.util.Arrays;
/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

 */
class Rotated_Matrix {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        rotate(arr,3);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] arr, int k) {
        int[] ans=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[(i + k) % arr.length] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=ans[i];
        }

}

}