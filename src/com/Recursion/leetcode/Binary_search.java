package com.Recursion.leetcode;
/*
Given an array of integers nums which is sorted in ascending order,
 and an integer target, write a function to search target in nums.
 If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
 */
public class Binary_search {
    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        System.out.println(search(nums,9));
    }
    public static int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        if(start>end){
            return -1;
        }
        int mid=start+(end - start)/2;
        if (arr[mid]==target){
            return mid;
        }
        if (arr[mid]<target){
            return binarySearch(arr,target,mid+1,end);
        }
        return binarySearch(arr,target,start,mid-1);

    }
}
